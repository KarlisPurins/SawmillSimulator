package engine;

import android.content.Context;
import android.widget.Toast;

import com.example.sawmillsimulator.MainActivity;

import java.util.ArrayList;

import woodMaterials.*;

public class Inventory {
    ArrayList<ArrayList<Object>> materials = new ArrayList<ArrayList<Object>>();
    ArrayList<WoodLog> woodLogs;
    ArrayList<DebarkedLog> debarkedLogs;
    ArrayList<CantedLog> cantedLogs;
    ArrayList<Plank> planks;

    public Inventory(){
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





    public void addMaterial(Wood woodToAdd){
        switch (woodToAdd.getPhase()){
            case 0:
                this.woodLogs.add((WoodLog) woodToAdd);
                break;
            case 1:
                this.debarkedLogs.add((DebarkedLog) woodToAdd);
                break;
            case 2:
                this.cantedLogs.add((CantedLog) woodToAdd);
                break;
            case 3:
                this.planks.add((Plank) woodToAdd);
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