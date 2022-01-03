package com.example.sawmillsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import engine.Inventory;
import woodMaterials.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int clickCount = 0;
    public static Inventory inventory = new Inventory();
    private static Application contexto;
    private static final DecimalFormat df = new DecimalFormat("0.00");

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

        TextView textLogTimer = (TextView)findViewById(R.id.textLogTimer);
        TextView textDebarkedLogTimer = (TextView)findViewById(R.id.textDebarkedLogTimer);
        TextView textCantedLogTimer = (TextView)findViewById(R.id.textCantedLogTimer);
        TextView textPlankTimer = (TextView)findViewById(R.id.textPlankTimer);

        Timer buttonTimer = new Timer();

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
                WoodLog lg = new WoodLog();
                if (clickCount == 0) {
                    ctAddLog(textLogTimer, inventory, lg, view);
                } else {
                    ctRemoveLog(textLogTimer, inventory, lg, view);
                }
                break;
            case R.id.btnAddDebLog:
                DebarkedLog dl = new DebarkedLog();
                if (clickCount == 0) {
                    ctCraftDebarkedLog(textDebarkedLogTimer, inventory, dl, view);
                } else {
                    ctRemoveDebarkedLog(textLogTimer, inventory, dl, view);
                }
                break;
            case R.id.btnAddCantLog:
                CantedLog cl = new CantedLog();
                if (clickCount == 0) {
                    ctCraftCantedLog(textCantedLogTimer, inventory, cl, view);
                } else {
                    ctRemoveCantedLog(textLogTimer, inventory, cl, view);
                }
                break;
            case R.id.btnAddPlank:
                Plank pl = new Plank();
                if (clickCount == 0) {
                    ctCraftPlank(textPlankTimer, inventory, pl, view);
                } else {
                    ctRemovePlank(textLogTimer, inventory, pl, view);
                }
                break;
            case R.id.btnToOrders:
                toast.setText("Goin to Orders");
                toast.show();
                goToOrders();
                break;
            case R.id.btnToWork:
                toast.setText("Goin to Work");
                toast.show();
                goToWork();
                break;
        }
    }

    public void ctAddLog(TextView text, Inventory inventory, WoodLog lg, View view) {
            view.setEnabled(false);
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

    public void ctCraftDebarkedLog(TextView text, Inventory inventory, DebarkedLog dl, View view) {
        if(inventory.getWoodLogs().size() <= 0) {
            MainActivity.makeToast("There are no logs in the Inventory");
        } else {
            view.setEnabled(false);
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
    }

    public void ctCraftCantedLog(TextView text, Inventory inventory, CantedLog cl, View view) {
        if(inventory.getDebarkedLogs().size() <= 0) {
            MainActivity.makeToast("There are no debarked logs in the Inventory");
        } else {
            view.setEnabled(false);
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
    }

    public void ctCraftPlank(TextView text, Inventory inventory, Plank pl, View view) {
        if (inventory.getCantedLogs().size() <= 0) {
            MainActivity.makeToast("There are no canted logs in the Inventory");
        } else {
            view.setEnabled(false);
            final int[] time = {5};
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    text.setText("0:" + checkDigit(time[0]));
                    time[0]--;
                }

                public void onFinish() {
                    text.setText("");
                    inventory.addMaterial(pl);
                    setTextViewText();
                }
            }.start();
        }
    }
    public void ctRemoveLog(TextView text, Inventory inventory, WoodLog lg, View view) {
        if (inventory.getWoodLogs().size() <= 0) {
            MainActivity.makeToast("There are no logs to remove in the Inventory");
        } else {
            view.setEnabled(false);
            final int[] time = {5};
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    text.setText("0:" + checkDigit(time[0]));
                    time[0]--;
                }

                public void onFinish() {
                    text.setText("");
                    inventory.removeMaterial(lg);
                    setTextViewText();
                }
            }.start();
        }
    }
    public void ctRemoveDebarkedLog(TextView text, Inventory inventory, DebarkedLog dl, View view) {
        if (inventory.getDebarkedLogs().size() <= 0) {
            MainActivity.makeToast("There are no debarked logs to remove in the Inventory");
        } else {
            view.setEnabled(false);
            final int[] time = {5};
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    text.setText("0:" + checkDigit(time[0]));
                    time[0]--;
                }

                public void onFinish() {
                    text.setText("");
                    inventory.removeMaterial(dl);
                    setTextViewText();
                }
            }.start();
        }
    }
    public void ctRemoveCantedLog(TextView text, Inventory inventory, CantedLog cl, View view) {
        if (inventory.getCantedLogs().size() <= 0) {
            MainActivity.makeToast("There are no canted logs to remove in the Inventory");
        } else {
            view.setEnabled(false);
            final int[] time = {5};
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    text.setText("0:" + checkDigit(time[0]));
                    time[0]--;
                }

                public void onFinish() {
                    text.setText("");
                    inventory.removeMaterial(cl);
                    setTextViewText();
                }
            }.start();
        }
    }
    public void ctRemovePlank(TextView text, Inventory inventory, Plank pl, View view) {
        if (inventory.getPlanks().size() <= 0) {
            MainActivity.makeToast("There are no planks to remove in the Inventory");
        } else {
            view.setEnabled(false);
            final int[] time = {5};
            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    text.setText("0:" + checkDigit(time[0]));
                    time[0]--;
                }

                public void onFinish() {
                    text.setText("");
                    inventory.removeMaterial(pl);
                    setTextViewText();
                }
            }.start();
        }
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

        Button btnToWork = (Button) findViewById(R.id.btnToWork);
        btnToWork.setOnClickListener(this);
    }

    private void goToOrders() {
        Intent switchActivityIntent = new Intent(this, OrdersActivity.class);
        startActivity(switchActivityIntent);
    }

    private void goToWork() {
        Intent switchActivityIntent = new Intent(this, WorkActivity.class);
        startActivity(switchActivityIntent);
    }

    private void setTextViewText(){
        TextView tv = findViewById(R.id.txtMoneyAmount_Main);
        tv.setText(""+df.format(inventory.getMoney())+"$");
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