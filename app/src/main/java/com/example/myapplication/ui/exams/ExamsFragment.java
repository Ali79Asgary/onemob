package com.example.myapplication.ui.exams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Exam;
import com.example.myapplication.ExamListAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ExamsFragment extends Fragment {

    private ExamsViewModel examsViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        examsViewModel = ViewModelProviders.of(this).get(ExamsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exams, container, false);

        final ListView examsListView = root.findViewById(R.id.examsListView);
        ArrayList<Exam> examList = genExams();
        ExamListAdapter examAdapter = new ExamListAdapter(this.getActivity(), R.layout.exams_view_layout, examList);
        examsListView.setAdapter(examAdapter);
        examsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        return root;
    }

    private ArrayList<Exam> genExams(){
        ArrayList<Exam> exams = new ArrayList<Exam>();
        Exam e1 = new Exam("ExamLink","آزمون یک");
        exams.add(e1);
        Exam e2 = new Exam("ExamLink","آزمون دو");
        exams.add(e2);
        Exam e3 = new Exam("ExamLink","آزمون سه");
        exams.add(e3);
        Exam e4 = new Exam("ExamLink","آزمون چهار");
        exams.add(e4);
        Exam e5 = new Exam("ExamLink","آزمون پنج");
        exams.add(e5);
        return exams;
    }
}
