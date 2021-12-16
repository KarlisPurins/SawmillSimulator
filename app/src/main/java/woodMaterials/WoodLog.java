package woodMaterials;

import androidx.annotation.NonNull;

import com.example.sawmillsimulator.MainActivity;

public class WoodLog extends Wood{
    static double defaultPrice = 20;

    public WoodLog(double defaultPrice) {
        super("Log", true, 0);
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
