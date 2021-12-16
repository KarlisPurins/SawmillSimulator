package com.example.sawmillsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import woodMaterials.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLog = (Button) findViewById(R.id.btnLog);
        btnLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        switch (view.getId()){
            case R.id.btnLog:
                clickingRoundRobin(toast, text);

        }
    }

    void clickingRoundRobin(Toast toast, CharSequence text){
        switch (clickCount){
            case 0:
                WoodLog wl = new WoodLog(WoodLog.getDefaultPrice());
                clickCount++;
                text = wl.toString();
                Log.d("Main", ""+WoodLog.getDefaultPrice());
                break;

            case 1:
                DebarkedLog dl = new DebarkedLog(DebarkedLog.getDefaultPrice());
                clickCount++;
                Log.d("Main", ""+DebarkedLog.getDefaultPrice());
                text = dl.toString();
                break;
            case 2:
                CantedLog cl = new CantedLog(CantedLog.getDefaultPrice());
                clickCount++;
                Log.d("Main", ""+CantedLog.getDefaultPrice());
                text = cl.toString();
                break;
            case 3:
                Plank pl = new Plank(Plank.getDefaultPrice());
                clickCount = 0;
                Log.d("Main", ""+Plank.getDefaultPrice());
                text = pl.toString();
                break;
        }
        toast.setText(text);
        toast.show();
    }
}