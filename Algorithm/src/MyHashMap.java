import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    private static final int SIZE = 10000;
    List<int[]>[] data;

    public MyHashMap() {
        data = new List[SIZE];
        for(int i = 0; i < SIZE; i++){
            data[i] = new ArrayList<>();
        }
    }
    
    public void put(int key, int value) {
        for (int[] pair : data[key % SIZE]){
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
 
      data[key % SIZE].add(new int[] {key, value});
    }
    
    public int get(int key) {
        for (int[] pair : data[key % SIZE])
            if (pair[0] == key)
                return pair[1];
        return -1;
    }
    
    public void remove(int key) {
        for(int[] pair : data[key % SIZE]){
            if(pair[0] == key){
                pair[1] = 0;
                return ;
            }
        }
        
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 10);
        System.out.println(obj.get(1));

    }
}