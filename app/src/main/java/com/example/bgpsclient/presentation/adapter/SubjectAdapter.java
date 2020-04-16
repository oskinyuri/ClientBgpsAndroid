package com.example.bgpsclient.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgpsclient.R;
import com.example.bgpsclient.domain.model.SubjectFullInfo;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {
    private List<SubjectFullInfo> mSubjects;

    public SubjectAdapter(@NonNull List<SubjectFullInfo> subjects) {
        mSubjects = subjects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(mSubjects.get(position));
    }

    @Override
    public int getItemCount() {
        return mSubjects.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mSubjectName;
        private TextView mSubjectType;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSubjectName = itemView.findViewById(R.id.subject_name);
            mSubjectType = itemView.findViewById(R.id.subject_type);
        }

        void bindView(final SubjectFullInfo subject) {
            mSubjectName.setText(subject.getName());
            mSubjectType.setText(subject.getType());
        }
    }
}
