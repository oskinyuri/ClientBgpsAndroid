package com.example.bgpsclient.data;

import com.example.bgpsclient.domain.model.JournalRecordExpanded;
import com.example.bgpsclient.domain.model.Student;
import com.example.bgpsclient.domain.model.StudyGroup;
import com.example.bgpsclient.domain.model.SubjectFullInfo;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    public static final String BASE_URL = "http://192.168.1.34:8080/";
    private final restApi mRestApi;

    public Repository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRestApi = retrofit.create(restApi.class);
    }

    public List<SubjectFullInfo> loadSubjects() throws IOException {
        Response<List<SubjectFullInfo>> response = mRestApi.getAllSubjects().execute();
        if (response.body() == null || response.errorBody() != null) {
            throw new IOException("Не удалось загрузить журнал");
        }
        return response.body();
    }

    public List<StudyGroup> loadAllGroups() throws IOException {
        Response<List<StudyGroup>> response = mRestApi.getAllStudyGroup().execute();
        if (response.body() == null || response.errorBody() != null) {
            throw new IOException("Не удалось загрузить журнал");
        }
        return response.body();
    }

    public List<Student> loadStudents(int groupId) throws IOException {
        Response<List<Student>> response = mRestApi.getAllStudents(groupId).execute();
        if (response.body() == null || response.errorBody() != null) {
            throw new IOException("Не удалось загрузить журнал");
        }
        return response.body();
    }

    public List<JournalRecordExpanded> loadJournalRecords(int studentId) throws IOException {
        Response<List<JournalRecordExpanded>> response = mRestApi.getAllJournalRecords(studentId).execute();
        if (response.body() == null || response.errorBody() != null) {
            throw new IOException("Не удалось загрузить журнал");
        }
        return response.body();
    }
}
