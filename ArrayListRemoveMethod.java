import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListRemoveMethod {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        System.out.println(list.size());
        System.out.println(list);
    }
}
