package com.example.sawmillsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

public class WorkActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvMoney;
    private Random random;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        tvMoney = findViewById(R.id.tvMoney);
        random = new Random();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgMoney:
                Animation a = AnimationUtils.loadAnimation(this, R.anim.money_animation);
                a.setAnimationListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        moneyClick();
                    }
                });
                v.startAnimation(a);
                break;
            case R.id.btnGoToInventory:
                goToInventory();
                break;
            }
    }

    private void moneyClick() {
        MainActivity.inventory.addMoney(0.10);
        tvMoney.setText(df.format(MainActivity.inventory.getMoney())+"$");
        showToast(R.string.clicked);
    }

    private void showToast(int stringID) {
        final Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER|Gravity.LEFT, random.nextInt(600)+100, random.nextInt(600)-300);
        toast.setDuration(Toast.LENGTH_SHORT);
        TextView textView = new TextView(this);
        textView.setText(stringID);
        textView.setTextSize(40f);
        textView.setTextColor(Color.GREEN);
        toast.setView(textView);
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                toast.show();
            }

            @Override
            public void onFinish() {
                toast.cancel();
            }
        };
        toast.show();
        toastCountDown.start();
    }
    private void goToInventory() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }
}