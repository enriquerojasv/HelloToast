package com.androidclase.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mToastButton;
    private Button mCountButton;
    private TextView mShowCount;
    private String mCounterString;
    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCounter = 0;

        mShowCount = (TextView) findViewById(R.id.show_count);

        mToastButton = (Button) findViewById(R.id.button_toast);
        mToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mCounterString, Toast.LENGTH_SHORT).show();

            }
        });

        mCountButton = (Button) findViewById(R.id.button_count);
        mCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter += 1;
                updateText();
            }
        });
    }

    public void updateText() {
        mCounterString = String.valueOf(mCounter);
        mShowCount.setText(mCounterString);
    }
}
