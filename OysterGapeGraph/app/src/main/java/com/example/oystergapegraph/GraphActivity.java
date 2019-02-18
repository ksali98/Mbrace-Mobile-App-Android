package com.example.oystergapegraph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;

public class GraphActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    GapeGraph gapeGraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        progressBar = findViewById(R.id.graphProgressBar);
        textView = findViewById(R.id.graphLoadingText);
        gapeGraph = new GapeGraph((LineChart)findViewById(R.id.line_chart));
        String file_name = getIntent().getStringExtra("GRAPHFILE");
        AsyncGraphGapeData gape_graph_task = new AsyncGraphGapeData(this, gapeGraph, textView,progressBar);
        gape_graph_task.execute(file_name);
    }
}
