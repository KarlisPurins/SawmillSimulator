package com.example.sawmillsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        //Jānodefinē pareizi textViews un jāsaglabā money ir kaut kādā failā.
        TextView tv = findViewById(R.id.txtMoneyAmount_Main);
        tv.setText(""+inventory.getMoney());
    }

    @Override
    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
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
                    inventory.addMaterial(lg);
                } else {
                    inventory.removeMaterial(lg);
                }
                toast.setText(inventory.toString());
                toast.show();
                break;
            case R.id.btnAddDebLog:
                DebarkedLog dl = new DebarkedLog();
                if (clickCount == 0) {
                    inventory.addMaterial(dl);
                } else {
                    inventory.removeMaterial(dl);
                }
                toast.setText(inventory.toString());
                toast.show();
                break;
            case R.id.btnAddCantLog:
                CantedLog cl = new CantedLog();
                if (clickCount == 0) {
                    inventory.addMaterial(cl);
                } else {
                    inventory.removeMaterial(cl);
                }
                toast.setText(inventory.toString());
                toast.show();
                break;
            case R.id.btnAddPlank:
                Plank pl = new Plank();
                if (clickCount == 0) {
                    inventory.addMaterial(pl);
                } else {
                    inventory.removeMaterial(pl);
                }
                toast.setText(inventory.toString());
                toast.show();
                break;
            case R.id.btnToOrders:
                toast.setText("Goin to Orders");
                toast.show();
                goToOrders();
                break;

        }
    }

    public static void makeToast(CharSequence text) {
        Context context = contexto;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }



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
}