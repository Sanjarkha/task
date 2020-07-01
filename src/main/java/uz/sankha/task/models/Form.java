package uz.sankha.task.models;

import javax.persistence.*;
import java.util.Date;

@Entity

@Table(name = "form")
public class Form {
    @Column(name = "Id")
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "regid")
    private String regId;

    @Column(name = "regdate")
    @Temporal(TemporalType.DATE)
    private Date regdate;


    @Column(name = "source_doc_id")
    private String source_doc_id;

    @Column(name = "source_doc_date")
    @Temporal(TemporalType.DATE)
    private Date source_doc_date;

    @Column(name = "deliveryform")
    private Integer deliveryform;

    @Column(name = "correspondent")
    private Integer correspondent;

    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    @Column(name = "periodofexecution")
    @Temporal(TemporalType.DATE)
    private Date periodofexecution;

    @Column(name = "access")
    private Boolean access;

    @Column(name = "control")
    private Boolean control;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "date")
    @Lob
    private byte[] data;

    public Form() {

    }

    public Form(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Form(String regId, Date regdate, String source_doc_id, Date source_doc_date, Integer deliveryform, Integer correspondent, String topic, String description, Date periodofexecution, Boolean access, Boolean control) {

        this.regId = regId;
        this.regdate = regdate;
        this.source_doc_id = source_doc_id;
        this.source_doc_date = source_doc_date;
        this.deliveryform = deliveryform;
        this.correspondent = correspondent;
        this.topic = topic;
        this.description = description;
        this.periodofexecution = periodofexecution;
        this.access = access;
        this.control = control;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String reg_Id) {
        this.regId = reg_Id;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date reg_date) {
        this.regdate = reg_date;
    }

    public String getSource_doc_id() {
        return source_doc_id;
    }

    public void setSource_doc_id(String source_doc_id) {
        this.source_doc_id = source_doc_id;
    }

    public Date getSource_doc_date() {
        return source_doc_date;
    }

    public void setSource_doc_date(Date source_doc_date) {
        this.source_doc_date = source_doc_date;
    }

    public Integer getDeliveryform() {
        return deliveryform;
    }

    public void setDeliveryform(Integer delivery_form) {
        this.deliveryform = delivery_form;
    }

    public Integer getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(Integer correspondent) {
        this.correspondent = correspondent;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPeriodofexecution() {
        return periodofexecution;
    }

    public void setPeriodofexecution(Date period_of_execution) {
        this.periodofexecution = period_of_execution;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public Boolean getControl() {
        return control;
    }

    public void setControl(Boolean control) {
        this.control = control;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
