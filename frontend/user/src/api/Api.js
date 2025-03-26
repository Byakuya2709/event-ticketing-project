import axios from "axios";
import { useToast } from "vue-toastification";
import { useAuthStore } from "@/stores/pina"; // Import store Pinia

const toast = useToast();

export const api = axios.create({
    baseURL: 'http://localhost:8080/',
    // baseURL: 'http://192.168.56.1:8080/',
    withCredentials: true, // 🌟 Cho phép gửi cookie
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
});


// // 🌟 Interceptor request: Tự động gán Authorization nếu token có trong Pinia
// api.interceptors.request.use((config) => {
//     const authStore = useAuthStore();
//     if (authStore.token) {
//         config.headers.Authorization = `Bearer ${authStore.token}`;
//     }
//     console.log('Request Headers:', config.headers);
//     return config;
// }, (error) => {
//     return Promise.reject(error);
// });

// 🚀 Interceptor response: Xử lý lỗi, tự động đăng xuất khi token hết hạn
let lastToastTime = 0;
const TOAST_THROTTLE_TIME = 3000; // Giới hạn 3 giây giữa các lần hiển thị

api.interceptors.response.use(
    (response) => response,
    (error) => {
        const now = Date.now();
        if (now - lastToastTime < TOAST_THROTTLE_TIME) {
            return Promise.reject(error); // Bỏ qua toast nếu quá gần nhau
        }
        lastToastTime = now;

        const authStore = useAuthStore();
        if (error.response) {
            const status = error.response.status;
            const message = error.response.data?.message || 'An error occurred';

            if (status === 401) {
                toast.error(`Unauthorized: ${message}`);
            } else if (status === 403) {
                toast.error(`Access Denied: ${message}`);
            } else {
                toast.error(`Error ${status}: ${message}`);
            }
        } else if (error.request) {
            toast.error('No response from server. Please check your network.');
        } else {
            toast.error(`Error: ${error.message}`);
        }
        return Promise.reject(error);
    }
);

