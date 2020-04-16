package com.example.bgpsclient.presentation.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgpsclient.R;
import com.example.bgpsclient.data.Repository;
import com.example.bgpsclient.domain.model.Student;
import com.example.bgpsclient.domain.model.StudyGroup;
import com.example.bgpsclient.presentation.ScreenRouter;
import com.example.bgpsclient.presentation.adapter.GroupAdapter;
import com.example.bgpsclient.presentation.adapter.StudentAdapter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class StudentFragment extends androidx.fragment.app.Fragment {

    private RecyclerView mRecyclerView;
    private Executor mExecutor;
    private Repository mRepository;
    private ScreenRouter mRouter;
    private int mGroupId;

    public static StudentFragment newInstance(ScreenRouter router, int groupId) {
        return new StudentFragment(router, groupId);
    }

    public StudentFragment(ScreenRouter router, int groupId) {
        mRouter = router;
        mGroupId = groupId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = new Repository();
        mExecutor = Executors.newFixedThreadPool(2);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mRecyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mExecutor.execute(() -> {
            try {
                List<Student> studyGroups = mRepository.loadStudents(mGroupId);
                requireActivity().runOnUiThread(() -> mRecyclerView.setAdapter(
                        new StudentAdapter(studyGroups, (id) -> mRouter.openJournalByStudent(id))));
            } catch (IOException e) {
                Log.v("WTF", "subject not load");
            }
        });
    }
}
