package com.example.bgpsclient.domain.model;

import com.google.gson.annotations.SerializedName;

public class JournalRecordExpanded {
    @SerializedName("id")
    private int id;
    @SerializedName("inTime")
    private boolean inTime;
    @SerializedName("count")
    private int count;
    @SerializedName("studentId")
    private int studentId;
    @SerializedName("studyPlanId")
    private int studyPlanId;
    @SerializedName("markId")
    private int markId;
    @SerializedName("subjectName")
    private String subjectName;
    @SerializedName("subjectShortName")
    private String subjectShortName;
    @SerializedName("examType")
    private String examType;
    @SerializedName("markName")
    private String markName;
    @SerializedName("markValue")
    private String markValue;

    public JournalRecordExpanded(int id, int studentId, int studyPlanId, boolean inTime, int count, int markId, String subjectName, String subjectShortName, String examType, String markName, String markValue) {
        this.id = id;
        this.studentId = studentId;
        this.studyPlanId = studyPlanId;
        this.inTime = inTime;
        this.count = count;
        this.markId = markId;
        this.subjectName = subjectName;
        this.subjectShortName = subjectShortName;
        this.examType = examType;
        this.markName = markName;
        this.markValue = markValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudyPlanId() {
        return studyPlanId;
    }

    public void setStudyPlanId(int studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public boolean isInTime() {
        return inTime;
    }

    public void setInTime(boolean inTime) {
        this.inTime = inTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectShortName() {
        return subjectShortName;
    }

    public void setSubjectShortName(String subjectShortName) {
        this.subjectShortName = subjectShortName;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getMarkValue() {
        return markValue;
    }

    public void setMarkValue(String markValue) {
        this.markValue = markValue;
    }
}