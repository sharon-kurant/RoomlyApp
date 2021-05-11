package com.example.Roomly.ui.roommates;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RoommatesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RoommatesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}