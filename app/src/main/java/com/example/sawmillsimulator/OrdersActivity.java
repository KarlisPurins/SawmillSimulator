package com.example.sawmillsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import engine.Order;

public class OrdersActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<TextView> textViews = new ArrayList<TextView>();
    ArrayList<Order> orders = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        createButtonsAndTheirOnClickListeners();
        initializeTextViews();
        createOrders();
    }

    private void initializeTextViews() {
        TextView tv1 = findViewById(R.id.txt1_Orders);
        TextView tv2 = findViewById(R.id.txt2_Orders);
        TextView tv3 = findViewById(R.id.txt3_Orders);
        textViews.add(tv1);
        textViews.add(tv2);
        textViews.add(tv3);
    }

    @Override
    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        switch (view.getId()) {
            case R.id.btnBackInOrders:
                toast.setText("Goin to Main");
                toast.show();
                goToMain();
                break;
            case R.id.btnOrder1Acc:
                if(inventoryHasEverything(toast, 0)){
                    MainActivity.inventory.addMoney(orders.get(0).getPrice()); //Can replace these lines with CompleteOrder method
                    removeOrderItemsFromInventory(0);               // as code optimization
                    removeOrder(0, R.id.btnOrder1Acc, view);        //
                    showOrderAcceptToast(toast);                               //
                }
                break;
            case R.id.btnOrder2Acc:
                if(inventoryHasEverything(toast, 1)){
                    MainActivity.inventory.addMoney(orders.get(1).getPrice());
                    removeOrderItemsFromInventory(1);
                    removeOrder(1, R.id.btnOrder2Acc, view);
                    showOrderAcceptToast(toast);
                }
                break;
            case R.id.btnOrder3Acc:
                if(inventoryHasEverything(toast, 2)){
                    MainActivity.inventory.addMoney(orders.get(2).getPrice());
                    removeOrderItemsFromInventory(2);
                    removeOrder(2, R.id.btnOrder3Acc, view);
                    showOrderAcceptToast(toast);
                }
                break;
        }
    }

    private void goToMain() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchActivityIntent);
    }

    private void createButtonsAndTheirOnClickListeners() {
        Button btnBack = (Button) findViewById(R.id.btnBackInOrders);
        btnBack.setOnClickListener(this);
        Button btnOrder1Acc = (Button) findViewById(R.id.btnOrder1Acc);
        btnOrder1Acc.setOnClickListener(this);
        Button btnOrder2Acc = (Button) findViewById(R.id.btnOrder2Acc);
        btnBack.setOnClickListener(this);
        Button btnOrder3Acc = (Button) findViewById(R.id.btnOrder3Acc);
        btnOrder3Acc.setOnClickListener(this);
    }

    void createOrders(){
        for(int i=0; i<3; i++){
            Order order = new Order();
            orders.add(order);
            textViews.get(i).setText(order.toString());
        }
    }

    private boolean inventoryHasEverything(Toast toast, int orderNumber) {
        if (MainActivity.inventory.getWoodLogs().size() < orders.get(orderNumber).getLogCount()) {
            toast.setText("Not enough Logs");
            toast.show();
            return false;
        }
        if (MainActivity.inventory.getDebarkedLogs().size() < orders.get(orderNumber).getDebarkedLogCount()) {
            toast.setText("Not enough Debarked Logs");
            toast.show();
            return false;
        }
        if (MainActivity.inventory.getCantedLogs().size() < orders.get(orderNumber).getCantedLogCount()) {
            toast.setText("Not enough Canted Logs");
            toast.show();
            return false;
        }
        if (MainActivity.inventory.getPlanks().size() < orders.get(orderNumber).getPlankCount()) {
            toast.setText("Not enough Planks");
            toast.show();
            return false;
        }
        return true;
    }

    private void removeOrderItemsFromInventory(int orderNumber){
        for(int i=0; i<orders.get(orderNumber).getLogCount(); i++){
            MainActivity.inventory.getWoodLogs().remove(0);
        }
        for(int i=0; i<orders.get(orderNumber).getDebarkedLogCount(); i++){
            MainActivity.inventory.getDebarkedLogs().remove(0);
        }
        for(int i=0; i<orders.get(orderNumber).getCantedLogCount(); i++){
            MainActivity.inventory.getCantedLogs().remove(0);
        }
        for(int i=0; i<orders.get(orderNumber).getPlankCount(); i++){
            MainActivity.inventory.getPlanks().remove(0);
        }
    }

    private void showOrderAcceptToast(Toast toast){
        toast.setText("Order sent!");
        toast.show();
    }

    void removeOrder(int orderNumber, int buttonId, View view){
        textViews.get(orderNumber).setText(""); //"Deletes" order text
        hideButton(buttonId, view);
    }

    private void hideButton(int id, View view){
        Button btn = (Button) findViewById(id);
        btn.setVisibility(view.INVISIBLE);
    }
}