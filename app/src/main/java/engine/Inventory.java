package engine;

import android.content.Context;
import android.widget.Toast;

import com.example.sawmillsimulator.MainActivity;

import java.util.ArrayList;

import woodMaterials.*;

public class Inventory {
    double money;
    ArrayList<ArrayList<Object>> materials = new ArrayList<ArrayList<Object>>();
    ArrayList<WoodLog> woodLogs;
    ArrayList<DebarkedLog> debarkedLogs;
    ArrayList<CantedLog> cantedLogs;
    ArrayList<Plank> planks;

    public Inventory(){
        this.money = 0;
        this.woodLogs = new ArrayList<WoodLog>();
        this.debarkedLogs = new ArrayList<DebarkedLog>();
        this.cantedLogs = new ArrayList<CantedLog>();
        this.planks = new ArrayList<Plank>();
    }

    public ArrayList<WoodLog> getWoodLogs(){
        return this.woodLogs;
    }

    public ArrayList<DebarkedLog> getDebarkedLogs(){
        return this.debarkedLogs;
    }

    public ArrayList<CantedLog> getCantedLogs(){
        return this.cantedLogs;
    }

    public ArrayList<Plank> getPlanks(){
        return this.planks;
    }

    public double getMoney(){return this.money;}
    public void addMoney(double add){this.money += add;}





    public void addMaterial(Wood woodToAdd){
        switch (woodToAdd.getPhase()){
            case 0:
                this.woodLogs.add((WoodLog) woodToAdd);
                break;
            case 1:
                if(woodLogs.size() <= 0){
                    MainActivity.makeToast("There are no logs in the Inventory");
                } else {
                    this.debarkedLogs.add((DebarkedLog) woodToAdd);
                    this.woodLogs.remove(woodLogs.size()-1);
                }
                break;
            case 2:
                if(debarkedLogs.size() <= 0){
                    MainActivity.makeToast("There are no debarked logs in the Inventory");
                } else {
                    this.cantedLogs.add((CantedLog) woodToAdd);
                    this.debarkedLogs.remove(debarkedLogs.size()-1);
                }
                break;
            case 3:
                if(cantedLogs.size() <= 0) {
                    MainActivity.makeToast("There are no canted logs in the Inventory");
                } else {
                    this.planks.add((Plank) woodToAdd);
                    this.cantedLogs.remove(cantedLogs.size()-1);
                }
                break;
        }
    }

    public void removeMaterial(Wood woodToAdd){
        switch (woodToAdd.getPhase()){
            case 0:
                if(this.woodLogs.size() == 0){
                    MainActivity.makeToast("No WoodLog in Inventory");
                    break;
                }
                this.woodLogs.remove(woodLogs.size()-1);
                break;
            case 1:
                if(this.debarkedLogs.size() == 0){
                    MainActivity.makeToast("No DebarkedLog in Inventory");
                    break;
                }
                this.debarkedLogs.remove(debarkedLogs.size()-1);
                break;
            case 2:
                if(this.cantedLogs.size() == 0){
                    MainActivity.makeToast("No CantedLog in Inventory");
                    break;
                }
                this.cantedLogs.remove(cantedLogs.size()-1);;
                break;
            case 3:
                if(this.planks.size() == 0){
                    MainActivity.makeToast("No Planks in Inventory");
                    break;
                }
                this.planks.remove(planks.size()-1);;
                break;
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                ", woodLogs=" + woodLogs.size() +
                ", debarkedLogs=" + debarkedLogs.size() +
                ", cantedLogs=" + cantedLogs.size() +
                ", planks=" + planks.size() +
                '}';
    }
}
