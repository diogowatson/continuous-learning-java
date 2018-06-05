import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Comparator;

public class Fruit implements Comparable<Fruit> {//overridden Comparable

    private String fruitName;
    private String fruitDesc;
    private int quantity;

    public Fruit(String fruitName , String fruitDesc, int quantity){
        super();
        this.fruitName = fruitName;
        this.fruitDesc = fruitDesc;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitDesc() {
        return fruitDesc;
    }

    public void setFruitDesc(String fruitDesc) {
        this.fruitDesc = fruitDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Compare override method
    @Override
    public int compareTo(Fruit compareFruit) {
        int compareQuantity = ((Fruit) compareFruit).getQuantity();

        //ascending order
        return this.quantity - compareQuantity;

    //to compare multiple propeties must use Comparator


    }
}