package com.example.oystergapegraph;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncGraphGapeData extends AsyncTask<String, Integer, char[]> {
    TextView textView;
    ProgressBar progressBar;
    Context context;
    GapeGraph gapeGraph;
    String fileName;

    static final int number_of_tasks = 2;
    int progress_count;

    AsyncGraphGapeData(Context context, GapeGraph gapeGraph, TextView textView, ProgressBar progressBar){
        this.gapeGraph = gapeGraph;
        this.context = context;
        this.textView = textView;
        this.progressBar = progressBar;
        progress_count = 0;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected char[] doInBackground(String... file) {
        fileName = file[0];
        MbraceFTP mbraceFTP = new MbraceFTP();
        char[] bytes;
        if(!mbraceFTP.ftp_client.isConnected())
        {
            UpdateProgress.update_progress_text(textView,"Connecting To Server...");
            mbraceFTP.connect_to_server();
        }
        publishProgress(1);
        UpdateProgress.update_progress_text(textView,"Retrieving Data From Server...");
        bytes =  mbraceFTP.Retrieve_Data_From_Server(fileName);
        mbraceFTP.disconnect_from_server();
        publishProgress(1);
        return bytes;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progress_count += values[0];
        UpdateProgress.update_progress_bar(progressBar, progress_count,number_of_tasks);
    }

    @Override
    protected void onPostExecute(char[] bytes) {
        super.onPostExecute(bytes);
        textView.post(new Runnable(){
            @Override
            public void run() {
                textView.setText("Done!");
            }
        });
        if(bytes != null)
        {
            gapeGraph.Set_Up_Graph(bytes, fileName);
            progressBar.setVisibility(View.INVISIBLE);
            UpdateProgress.turn_text_view_invisible(textView);
        }
        else
        {
            UpdateProgress.update_progress_text(textView,"Unable To Get Any Data. Check Connection.");
        }
    }
}
