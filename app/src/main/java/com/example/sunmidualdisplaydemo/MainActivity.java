package com.example.sunmidualdisplaydemo;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button = null;
    Context context = null;
    Display mainScreen, viceScreen;
    DifferentDisplay mPresentation;
    private static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        DisplayManager mDisplayManager;//Screen management class
        Display[] displays;
        mDisplayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        displays = mDisplayManager.getDisplays();

        if (displays != null && displays.length > 1) {

            mainScreen = displays[0];
            viceScreen = displays[1];

            mPresentation = new DifferentDisplay(context, viceScreen, this);
            button = findViewById(R.id.hello_text_view);
            mPresentation.show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context, "Display 1", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
