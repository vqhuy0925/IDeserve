import java.util.Arrays;

public class MyHashMapWithArrayUtils {
    private static final int SIZE = 10000;
    int[] mapArray;

    public MyHashMapWithArrayUtils() {
        mapArray = new int[SIZE];
        Arrays.fill(mapArray, -1);
    }

    public void put(int key, int value) {
        mapArray[key] = value;
    }
    
    public int get(int key) {
        return mapArray[key];
    }
    
    public void remove(int key) {
        mapArray[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMapWithArrayUtils objArrayUtils = new MyHashMapWithArrayUtils();
        objArrayUtils.put(20, 50);
        objArrayUtils.put(21, 45);
        objArrayUtils.remove(20);
        System.out.println(objArrayUtils.get(20));
    }
}
