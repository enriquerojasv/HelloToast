package com.androidclase.hellorelative;

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
    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt("COUNTER", 0);
            mShowCount.setText(String.valueOf(mCounter));
        }

        mCounterString = String.valueOf(mCounter);

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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("COUNTER", mCounter);
    }

    public void updateText() {
        mCounterString = String.valueOf(mCounter);
        mShowCount.setText(mCounterString);
    }
}
