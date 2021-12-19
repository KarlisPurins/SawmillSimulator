package woodMaterials;

import androidx.annotation.NonNull;

import com.example.sawmillsimulator.MainActivity;

public class WoodLog extends Wood {
    static double defaultPrice = 20;

    public WoodLog() {
        super("Log", true, 0);
        this.price = defaultPrice;
    }

    public static double getDefaultPrice() {
        return defaultPrice;
    }

}
