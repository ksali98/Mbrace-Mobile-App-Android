package com.example.oystergapegraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.github.mikephil.charting.charts.LineChart;

public class GraphActivity extends AppCompatActivity {
    GapeGraph gapeGraph;
    boolean[] checkbox = {true, true, true, true, true, true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        gapeGraph = new GapeGraph((LineChart) findViewById(R.id.line_chart));
        gapeGraph.Set_Up_Graph(RetrieveDataActivity.data, RetrieveDataActivity.file_name, checkbox);
    }

    public void On_CheckBox_Clicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkbox1:
                checkbox[0] = checked ? true : false;
                break;
            case R.id.checkbox2:
                checkbox[1] = checked ? true : false;
                break;
            case R.id.checkbox3:
                checkbox[2] = checked ? true : false;
                break;
            case R.id.checkbox4:
                checkbox[3] = checked ? true : false;
                break;
            case R.id.checkbox5:
                checkbox[4] = checked ? true : false;
                break;
            case R.id.checkbox6:
                checkbox[5] = checked ? true : false;
                break;
        }
        gapeGraph.Set_Up_Graph(RetrieveDataActivity.data, RetrieveDataActivity.file_name, checkbox);
    }
}
