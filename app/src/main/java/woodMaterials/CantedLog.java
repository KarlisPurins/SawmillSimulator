package woodMaterials;

import androidx.annotation.NonNull;

public class CantedLog extends Wood{
    static double defaultPrice = 35;

    public CantedLog() {
        super("CantedLog", true, 2);
        this.price = defaultPrice;
    }

    public static double getDefaultPrice() { return defaultPrice; }


}
