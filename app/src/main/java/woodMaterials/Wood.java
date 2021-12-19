package woodMaterials;

import androidx.annotation.NonNull;

public class Wood {
    String name;
    boolean isSellable;
    double price;
    int phase; //0 - WoodLog; 1 - DebarkedLog; 2 - CantedLog; 3 - Plank

    public Wood(String name, boolean isSellable, int phase){ //phase - production chain phase
        this.name = name;
        this.isSellable = isSellable;
        this.phase = phase;
    }

    public int getPhase(){
        return this.phase;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name + "___"+ this.price + "___";
    }



}
