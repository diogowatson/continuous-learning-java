import java.util.Comparator;

public class Static {
    public static Comparator<Fruit> fruitNameComparator = new Comparator<Fruit>() {
        @Override
        public int compare(Fruit fruit1, Fruit fruit2) {
            String fruitName1 = fruit1.getFruitName().toUpperCase();
            String fruitName2 = fruit2.getFruitName().toUpperCase();

            return fruitName1.compareTo(fruitName2);
        }
    };
}
