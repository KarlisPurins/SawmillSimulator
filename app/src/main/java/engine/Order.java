package engine;

import java.util.Random;

public class Order {
    Random rnd = new Random();
    String[] nameArray = {"KokaVita", "TreeEater", "WoodMan", "Timberitto", "Dzerevnya"};
    String name;
    int logCount, debarkedLogCount, cantedLogCount, plankCount;
    double price;

    public Order(){
        this.name = nameArray[rnd.nextInt(5)];
        this.logCount = rnd.nextInt(5);
        this.debarkedLogCount = rnd.nextInt(5);
        this.cantedLogCount = rnd.nextInt(5);
        this.plankCount = rnd.nextInt(5);
        this.price = rnd.nextInt(100)+50;
    }

    public int getLogCount(){
        return this.logCount;
    }

    public int getDebarkedLogCount(){
        return this.debarkedLogCount;
    }

    public int getCantedLogCount(){
        return this.cantedLogCount;
    }

    public int getPlankCount(){
        return this.plankCount;
    }

    @Override
    public String toString(){
        return this.name + ":\n" + "Logs: "+this.logCount + "\nDebarkedLogs: " + this.debarkedLogCount +
                "\nCantedLogs: " + this.cantedLogCount + "\nPlanks: " + this.plankCount +
                "\nPrice: " + this.price + "$";
    }

    public double getPrice(){
        return this.price;
    }


}
