package woodMaterials;

public class Wood {
    String name;
    boolean isSellable;
    double price;

    public Wood(String name, boolean isSellable, int phase){
        this.name = name;
        this.isSellable = isSellable;
        switch (phase){
            case 0:
                this.price = WoodLog.getDefaultPrice();
            case 1:
                this.price = DebarkedLog.getDefaultPrice();
            case 2:
                this.price = CantedLog.getDefaultPrice();
            case 3:
                this.price = Plank.getDefaultPrice();
        }


    }



}
