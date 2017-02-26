package com.example.divya.notepal.Model;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Divya on 23-02-2017.
 */

public class SpecialDaysModel {
    public String specialDayTitle;
    public String spacialDayDate;
    public  SpecialDaysModel(){

    }

    public SpecialDaysModel(String specialDayTitle, String spacialDayDate) {
        this.specialDayTitle = specialDayTitle;
        this.spacialDayDate = spacialDayDate;
    }

    public String getSpecialDayTitle() {
        return specialDayTitle;
    }

    public void setSpecialDayTitle(String specialDayTitle) {
        this.specialDayTitle = specialDayTitle;
    }

    public String getSpacialDayDate() {
        return spacialDayDate;
    }

    public void setSpacialDayDate(String spacialDayDate) {
        this.spacialDayDate = spacialDayDate;
    }



}
