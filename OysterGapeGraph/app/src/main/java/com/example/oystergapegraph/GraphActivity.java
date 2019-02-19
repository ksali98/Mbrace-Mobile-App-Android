package com.example.oystergapegraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;

public class GraphActivity extends AppCompatActivity {
    GapeGraph gapeGraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        gapeGraph = new GapeGraph((LineChart)findViewById(R.id.line_chart));
        gapeGraph.Set_Up_Graph(RetrieveDataActivity.data, RetrieveDataActivity.file_name);
    }
}
