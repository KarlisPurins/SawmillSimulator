package woodMaterials;

import androidx.annotation.NonNull;

public class Plank extends Wood{
    static double defaultPrice = 10; //There are 5 planks from 1 CantedLog

    public Plank(double defaultPrice) {
        super("Plank", true, 3);
    }

    public static double getDefaultPrice() {
        return defaultPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name + "___"+ this.price + "___";
    }

}
