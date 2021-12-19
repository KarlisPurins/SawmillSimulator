package woodMaterials;

import androidx.annotation.NonNull;

public class DebarkedLog extends Wood{
    static double defaultPrice = 25;

    public DebarkedLog() {
        super("DebarkedLog", true, 1);
        this.price = defaultPrice;
    }

    public static double getDefaultPrice() {
        return defaultPrice;
    }


}
