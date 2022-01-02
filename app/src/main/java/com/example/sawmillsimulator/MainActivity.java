package com.example.sawmillsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import engine.Inventory;
import woodMaterials.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int clickCount = 0;
    public static Inventory inventory = new Inventory();
    private static Application contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButtonsAndTheirOnClickListeners();
        contexto = (Application) this.getApplicationContext();
        //jāsaglabā money ir kaut kādā failā.
        setTextViewText();
    }

    @Override
    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);

        Timer buttonTimer = new Timer();

        TextView textLogTimer = (TextView)findViewById(R.id.textLogTimer);
        TextView textDebarkedLogTimer = (TextView)findViewById(R.id.textDebarkedLogTimer);
        TextView textCantedLogTimer = (TextView)findViewById(R.id.textCantedLogTimer);
        TextView textPlankTimer = (TextView)findViewById(R.id.textPlankTimer);

        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        view.setEnabled(true);
                    }
                });
            }
        }, 5000);

        switch (view.getId()) {
            case R.id.btnLog:
                if (clickCount == 0) {
                    changeButtonTexts();
                    clickCount = 1;
                } else {
                    changeButtonTexts();
                    clickCount = 0;
                }
                break;
            case R.id.btnAddLog:
                view.setEnabled(false);
                WoodLog lg = new WoodLog();
                if (clickCount == 0) {
                    ctAddLog(textLogTimer, inventory, lg);
                } else {
                    ctRemoveLog(textLogTimer, inventory, lg);
                }
                break;
            case R.id.btnAddDebLog:
                view.setEnabled(false);
                DebarkedLog dl = new DebarkedLog();
                if (clickCount == 0) {
                    ctAddDebarkedLog(textDebarkedLogTimer, inventory, dl);
                } else {
                    ctRemoveDebarkedLog(textLogTimer, inventory, dl);
                }
                break;
            case R.id.btnAddCantLog:
                view.setEnabled(false);
                CantedLog cl = new CantedLog();
                if (clickCount == 0) {
                    ctAddCantedLog(textCantedLogTimer, inventory, cl);
                } else {
                    ctRemoveCantedLog(textLogTimer, inventory, cl);
                }
                break;
            case R.id.btnAddPlank:
                view.setEnabled(false);
                Plank pl = new Plank();
                if (clickCount == 0) {
                    ctAddPlank(textPlankTimer, inventory, pl);
                } else {
                    ctRemovePlank(textLogTimer, inventory, pl);
                }
                break;
            case R.id.btnToOrders:
                toast.setText("Goin to Orders");
                toast.show();
                goToOrders();
                break;
        }
    }

    public void ctAddLog(TextView text, Inventory inventory, WoodLog lg) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.addMaterial(lg);
                setTextViewText();
            }
        }.start();
    }

    public void ctAddDebarkedLog(TextView text, Inventory inventory, DebarkedLog dl) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.addMaterial(dl);
                setTextViewText();
            }
        }.start();
    }

    public void ctAddCantedLog(TextView text, Inventory inventory, CantedLog cl) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.addMaterial(cl);
                setTextViewText();
            }
        }.start();
    }

    public void ctAddPlank(TextView text, Inventory inventory, Plank pl) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.addMaterial(pl);
                setTextViewText();
            }
        }.start();
    }

    public void ctRemoveLog(TextView text, Inventory inventory, WoodLog lg) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.removeMaterial(lg);
                setTextViewText();
            }
        }.start();
    }

    public void ctRemoveDebarkedLog(TextView text, Inventory inventory, DebarkedLog dl) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.removeMaterial(dl);
                setTextViewText();
            }
        }.start();
    }

    public void ctRemoveCantedLog(TextView text, Inventory inventory, CantedLog cl) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.removeMaterial(cl);
                setTextViewText();
            }
        }.start();
    }

    public void ctRemovePlank(TextView text, Inventory inventory, Plank pl) {
        final int[] time = {5};
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText("0:"+checkDigit(time[0]));
                time[0]--;
            }

            public void onFinish() {
                text.setText("");
                inventory.removeMaterial(pl);
                setTextViewText();
            }
        }.start();
    }

    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    public static void makeToast(CharSequence text) {
        Context context = contexto;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    //Changes button texts from "add" to "remove" and vice versa
    private void changeButtonTexts() {
        Button btnAddLog = (Button) findViewById(R.id.btnAddLog);
        Button btnAddDebLog = (Button) findViewById(R.id.btnAddDebLog);
        Button btnAddCantLog = (Button) findViewById(R.id.btnAddCantLog);
        Button btnAddPlank = (Button) findViewById(R.id.btnAddPlank);
        if(clickCount == 0){
            btnAddLog.setText(R.string.removeLog_button);
            btnAddDebLog.setText(R.string.removeDebarkedLog_button);
            btnAddCantLog.setText(R.string.removeCantedLog_button);
            btnAddPlank.setText(R.string.removePlank_button);
        }else{
            btnAddLog.setText(R.string.addLog_button);
            btnAddDebLog.setText(R.string.addDebarkedLog_button);
            btnAddCantLog.setText(R.string.addCantedLog_button);
            btnAddPlank.setText(R.string.addPlank_button);
        }

    }

    private void createButtonsAndTheirOnClickListeners() {
        Button btnLog = (Button) findViewById(R.id.btnLog);
        btnLog.setOnClickListener(this);

        Button btnAddLog = (Button) findViewById(R.id.btnAddLog);
        btnAddLog.setOnClickListener(this);

        Button btnAddDebLog = (Button) findViewById(R.id.btnAddDebLog);
        btnAddDebLog.setOnClickListener(this);

        Button btnAddCantLog = (Button) findViewById(R.id.btnAddCantLog);
        btnAddCantLog.setOnClickListener(this);

        Button btnAddPlank = (Button) findViewById(R.id.btnAddPlank);
        btnAddPlank.setOnClickListener(this);

        Button btnToOrders = (Button) findViewById(R.id.btnToOrders);
        btnToOrders.setOnClickListener(this);
    }

    private void goToOrders() {
        Intent switchActivityIntent = new Intent(this, OrdersActivity.class);
        startActivity(switchActivityIntent);
    }

    private void setTextViewText(){
        TextView tv = findViewById(R.id.txtMoneyAmount_Main);
        tv.setText(""+inventory.getMoney());
        TextView woodLogs = findViewById(R.id.txtWoodLogs);
        woodLogs.setText("Logs: " + inventory.getWoodLogs().size());
        TextView debLogs = findViewById(R.id.txtDebLogs);
        debLogs.setText("Debarked Logs: " + inventory.getDebarkedLogs().size());
        TextView cantedLogs = findViewById(R.id.txtCantedLogs);
        cantedLogs.setText("Canted Logs: " + inventory.getCantedLogs().size());
        TextView planks = findViewById(R.id.txtPlanks);
        planks.setText("Planks: " + inventory.getPlanks().size());
    }
}