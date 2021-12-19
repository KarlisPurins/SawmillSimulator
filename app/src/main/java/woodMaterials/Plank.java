package woodMaterials;

import androidx.annotation.NonNull;

public class Plank extends Wood{
    static double defaultPrice = 10; //There are 5 planks from 1 CantedLog

    public Plank() {
        super("Plank", true, 3);
        this.price = defaultPrice;
    }

    public static double getDefaultPrice() {
        return defaultPrice;
    }



}
