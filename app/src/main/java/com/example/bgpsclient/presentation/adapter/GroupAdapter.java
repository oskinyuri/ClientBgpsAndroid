package com.example.bgpsclient.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgpsclient.R;
import com.example.bgpsclient.domain.model.StudyGroup;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private List<StudyGroup> mList;
    private OnItemClickListener mListener;

    public GroupAdapter(@NonNull List<StudyGroup> list, OnItemClickListener listener) {
        mList = list;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
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
        private TextView mGroupName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mGroupName = itemView.findViewById(R.id.group_name);
        }

        void bindView(final StudyGroup studyGroup, OnItemClickListener listener) {
            mGroupName.setText(studyGroup.getName());
            itemView.setOnClickListener((view) -> {
                listener.onItemClick(studyGroup.getId());
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int studyGroupId);
    }
}
