/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author admin
 */
@Entity
@Table(name = "submission")
public class Submission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private Long submissionId;

    //tieu de
    @Column(name = "sub_subject", nullable = false)
    private String subSubject;

    //    ngày tạo
    @Column(name = "sub_create_date", nullable = false)
    private Date subCreateDate;

    //ngay duyet
    @Column(name = "sub_finish_date")
    private Date subFinishDate;

    //trang thai , pending, aproved, reject
    @Column(name = "sub_status", nullable = false)
    private String subStatus;


    //han chót
    @Column(name = "sub_deadline", nullable = false)
    private Date subDeadline;


    //noi dung
    @Lob
    @Column(name = "sub_content", nullable = false)
    private String subContent;

    @Column(name = "sub_formdata", nullable = false)
    private String subFormdata;

    @Column(name = "sub_company_id")
    private String subCompanyId;

    @Column(name = "sub_company_name")
    private String subCompanyName;

    // Quan hệ 1 Submission chỉ thuộc về 1 Event
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private Event event;

    // Getters, Setters, Constructors
    public Submission() {
    }

    // Các getter và setter sẽ tương tự.
    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public String getSubSubject() {
        return subSubject;
    }

    public void setSubSubject(String subSubject) {
        this.subSubject = subSubject;
    }

    public Date getSubCreateDate() {
        return subCreateDate;
    }

    public void setSubCreateDate(Date subCreateDate) {
        this.subCreateDate = subCreateDate;
    }

    public Date getSubFinishDate() {
        return subFinishDate;
    }

    public void setSubFinishDate(Date subFinishDate) {
        this.subFinishDate = subFinishDate;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public Date getSubDeadline() {
        return subDeadline;
    }

    public void setSubDeadline(Date subDeadline) {
        this.subDeadline = subDeadline;
    }

    public String getSubContent() {
        return subContent;
    }

    public void setSubContent(String subContent) {
        this.subContent = subContent;
    }

    public String getSubCompanyId() {
        return subCompanyId;
    }

    public void setSubCompanyId(String subCompanyId) {
        this.subCompanyId = subCompanyId;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getSubCompanyName() {
        return subCompanyName;
    }

    public void setSubCompanyName(String subCompanyName) {
        this.subCompanyName = subCompanyName;
    }

    public String getSubFormdata() {
        return subFormdata;
    }

    public void setSubFormdata(String subFormdata) {
        this.subFormdata = subFormdata;
    }
}
