package com.example.bgpsclient.data;

import com.example.bgpsclient.domain.model.JournalRecordExpanded;
import com.example.bgpsclient.domain.model.Student;
import com.example.bgpsclient.domain.model.StudyGroup;
import com.example.bgpsclient.domain.model.SubjectFullInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface restApi {

    @GET("/subject")
    Call<List<SubjectFullInfo>> getAllSubjects();

    @GET("/study-group")
    Call<List<StudyGroup>> getAllStudyGroup();

    @GET("/student/study-group-id/{studyGroupId}")
    Call<List<Student>> getAllStudents(@Path("studyGroupId") int studyGroupId);

    @GET("/journal/expended-student/{studentId}")
    Call<List<JournalRecordExpanded>> getAllJournalRecords(@Path("studentId") int studentId);
}
