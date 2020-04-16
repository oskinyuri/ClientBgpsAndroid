package com.example.bgpsclient.presentation.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bgpsclient.R;
import com.example.bgpsclient.domain.model.JournalRecordExpanded;

import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.ViewHolder> {
    private List<JournalRecordExpanded> mList;

    public JournalAdapter(@NonNull List<JournalRecordExpanded> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.journal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mSubjectName;
        private TextView mSubjectType;
        private TextView mMarkName;
        private TextView mCount;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mSubjectName = itemView.findViewById(R.id.journal_subject_name);
            mSubjectType = itemView.findViewById(R.id.journal_subject_type);
            mMarkName = itemView.findViewById(R.id.journal_subject_mark_name);
            mCount = itemView.findViewById(R.id.journal_subject_count);
        }

        void bindView(final JournalRecordExpanded journal) {
            mSubjectName.setText(journal.getSubjectName());
            mSubjectType.setText(journal.getExamType());
            mMarkName.setText(journal.getMarkName());
            String count = "Кол-во пересдач: " + journal.getCount();
            mCount.setText(count);
            if (journal.getMarkValue().contains("з"))
                return;
            if (journal.getMarkValue().contains("н") || (journal.getMarkValue().equals("")) || (Integer.parseInt(journal.getMarkValue()) <= 3)) {
                mMarkName.setBackgroundColor(Color.RED);
                mSubjectType.setBackgroundColor(Color.RED);
            }
        }
    }
}
