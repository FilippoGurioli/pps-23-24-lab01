import tdd.CircularList;
import tdd.CircularListImpl;

public class Main {
    public static void main(String[] args) {
        CircularList list = new CircularListImpl();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.next();
        System.out.println(list);
    }
}
