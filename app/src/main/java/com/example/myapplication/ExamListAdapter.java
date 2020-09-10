package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExamListAdapter extends ArrayAdapter<Exam> {

    private static final String TAG = "ExamListAdapter";
    private Context examContext;
    int examResource;

    public ExamListAdapter(@NonNull Context context, int resource, @NonNull List<Exam> objects) {
        super(context, resource, objects);
        examContext = context;
        examResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String examLink = getItem(position).getExamLink();
        String examName = getItem(position).getExamName();

        Exam exam = new Exam(examLink, examName);

        LayoutInflater layoutInflater = LayoutInflater.from(examContext);
        convertView = layoutInflater.inflate(examResource, parent, false);

        TextView lblExamName = convertView.findViewById(R.id.exam_name);
        lblExamName.setText(examName);

        return convertView;
    }
}
