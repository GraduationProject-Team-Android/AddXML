package com.example.graduationproject;

import android.widget.RadioButton;
import android.widget.RadioGroup;

public interface OnClickListener_Radio_Buttons {
    public void options(RadioGroup rb_group,RadioButton option1, RadioButton option2 , RadioButton option3, int position,int indexSelectedAnswer);
    public void showSolutions(RadioButton option1, RadioButton option2 , RadioButton option3);
}
