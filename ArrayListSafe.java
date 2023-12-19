import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Data {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public void add(){
        arrayList.add(new Random().nextInt(9));
    }

    public void print(){
        System.out.println(arrayList.size());
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("第"+i+"个元素："+arrayList.get(i));
        }
    }
}

public class ArrayListSafe {
    public static void main(String[] args) {
        Data data = new Data();
        for (int j = 0; j < 2; j++) {
            new Thread(() -> {
                synchronized (data) {
                    for (int i = 0; i < 100; i++) {
                        data.add();
                    }
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
            data.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
