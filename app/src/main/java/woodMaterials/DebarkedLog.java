package woodMaterials;

import androidx.annotation.NonNull;

public class DebarkedLog extends Wood{
    static double defaultPrice = 25;

    public DebarkedLog(double defaultPrice) {
        super("DebarkedLog", true, 1);
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
