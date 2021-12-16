package woodMaterials;

import androidx.annotation.NonNull;

public class CantedLog extends Wood{
    static double defaultPrice = 35;

    public CantedLog(double defaultPrice) {
        super("CantedLog", true, 2);
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
