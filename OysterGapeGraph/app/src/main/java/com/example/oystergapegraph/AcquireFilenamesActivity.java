package com.example.oystergapegraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AcquireFilenamesActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acquire_filenames);
        progressBar = findViewById(R.id.progressAcquireFiles);
        textView = findViewById(R.id.textAcquireFiles);
        AsyncGetFilenames get_filenames_task = new AsyncGetFilenames(this, progressBar, textView);
        get_filenames_task.execute();
    }
}
