import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({

  base: '/CT250_UserFE/', // Thay bằng tên repo GitHub của bạn
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  css: {
    postcss: './postcss.config.js',
  },

  server: {
    port: 3001, // Chỉ định cổng mà máy chủ phát triển của bạn sẽ chạy
    proxy: {
      "/api": {
        target: "http://localhost:8080/", // Chỉ định máy chủ đích mà các yêu cầu sẽ được chuyển tiếp đến
        changeOrigin: true, // Thay đổi nguồn gốc của tiêu đề máy chủ đến URL đích
      },
    },
  },
})
