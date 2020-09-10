package com.example.myapplication.ui.exams;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExamsViewModel extends ViewModel {
    private MutableLiveData<String> examText;

    public ExamsViewModel() {
        examText = new MutableLiveData<>();
        examText.setValue("قسمت آزمونها");
    }

    public LiveData<String> getExamText() {return examText;}
}
