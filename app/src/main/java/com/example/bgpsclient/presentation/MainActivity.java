package com.example.bgpsclient.presentation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bgpsclient.R;
import com.example.bgpsclient.presentation.fragment.JournalFragment;
import com.example.bgpsclient.presentation.fragment.SubjectsFragment;
import com.example.bgpsclient.presentation.fragment.GroupFragment;
import com.example.bgpsclient.presentation.fragment.StudentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener, ScreenRouter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, SubjectsFragment.newInstance())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        androidx.fragment.app.Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.subject:
                selectedFragment = SubjectsFragment.newInstance();
                break;
            case R.id.journal:
                selectedFragment = GroupFragment.newInstance(this);
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, selectedFragment);
        transaction.commit();
        return true;
    }

    @Override
    public void openStudentsByGroup(int groupId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, StudentFragment.newInstance(this, groupId));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openJournalByStudent(int studentId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, JournalFragment.newInstance(this, studentId));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                FragmentManager fm = getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                    return true;
                }
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
