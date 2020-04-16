package com.example.bgpsclient.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgpsclient.R;
import com.example.bgpsclient.domain.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> mList;
    private OnItemClickListener mListener;

    public StudentAdapter(@NonNull List<Student> list, OnItemClickListener listener) {
        mList = list;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(mList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mFullName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.student_surname);
            mFullName = itemView.findViewById(R.id.student_full_name);
        }

        void bindView(final Student student, OnItemClickListener listener) {
            mName.setText(student.getSecondName());
            String fullName = student.getName() + " " + student.getSurname();
            mFullName.setText(fullName);
            itemView.setOnClickListener((view) -> {
                listener.onItemClick(student.getId());
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int studyGroupId);
    }
}
