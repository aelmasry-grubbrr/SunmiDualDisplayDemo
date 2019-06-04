package com.example.sunmidualdisplaydemo;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
class DifferentDisplay extends Presentation {
    private Button addTipButton, enterButton = null;
    private NumericEditText numericEditText = null;
    private Activity activity = null;

    DifferentDisplay(Context outerContext, Display display, Activity activity) {
        super(outerContext, display);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_display);

        addTipButton = findViewById(R.id.add_tip_btn);
        enterButton = findViewById(R.id.button_enter);
        numericEditText = findViewById(R.id.et_tip);

        MyKeyboard keyboard = (MyKeyboard) findViewById(R.id.keyboard);
        numericEditText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        numericEditText.setTextIsSelectable(true);

        InputConnection ic = numericEditText.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, NextActivity.class));
            }
        });

        addTipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, NextActivity.class));
            }
        });
    }
}