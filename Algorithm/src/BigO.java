import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigO {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3 ,4};
        int[] arrayB = new int[] {5, 6, 7, 1};
        foo(array);
        printPairs(array);
        printUnorderedPairs(array);
        printUnorderedPairs(array, arrayB);
        printUnorderedPairs2(array, arrayB);
        reserse(array);
        Node node  = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        System.out.println("Sum "+ sum(node));
        System.out.println(isPrime(3));
        System.out.println(factorial(5));
        sum();
        permutation("ABC");
        showHiddenFiles();
    }

    //O(n)
    static void foo(int[] array){
        int sum = 0;
        int product = 1;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        for(int j = 0; j < array.length; j++){
            product *= array[j];
        }

        System.out.println("sum " + sum + " product: "+ product);

    }

    //O(n2)
    static void printPairs(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                System.out.println(array[i] + ", "+ array[j]);
            }
        }
    }

    //O(n2)
    static void printUnorderedPairs(int[] array){
       for (int i = 0; i < array.length; i ++) {
            for(int j = i+1; j < array.length; j++){
                System.out.println(array[i] +" , "+array[j]);
            }
       }
    }

    //O(ab)
    static void printUnorderedPairs(int[] arrayA, int[] arrayB){
        for(int i = 0; i < arrayA.length; i++){
            for(int j = 0; j < arrayB.length; j++){
                if(arrayA[i] < arrayB[j]){
                    System.out.println(arrayA[i]+" , "+ arrayB[j]);
                }
            }
        }
    }

    //O(n2)
    static void printUnorderedPairs2(int[] arrayA, int[] arrayB){
        for(int i = 0; i < arrayA.length; i++){
            for(int j = 0; j < arrayB.length; j++){
                for(int k = 0; k < 10000; k++){
                    System.out.println(arrayA[i]+" , " + arrayB[j]);
                }
            }
        }
    }

    //O(n)
    static void reserse(int[] array){
        for(int i = 0 ; i < array.length/2; i++){
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
        for(int j = 0; j < array.length; j++){
            System.out.println(array[j]);
        }
    }

    static int sum(Node node){
        if(node == null){
            return 0;
        }
        return sum(node.left) + node.data + sum(node.right);
    }

    //O(square root n)
    static boolean isPrime(int n){
        for(int x = 2; x*x <= n; x++){
            if(n % x == 0){
                return false;
            }
        }
        return true;
    }

    //O(n)
    static int factorial(int n){
        if(n<0){
            return -1;
        }else if(n==0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }

    public static void sum(){
        int [] nums = {1,2,3,4,5};
        List<Integer> ars = Arrays.asList(1,2,3,4,5);
        Integer sum1 = Arrays.stream(nums).sum();
        Integer sum2 = ars.stream().reduce(0, Integer::sum);
        Integer sum3 = ars.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }

    static void permutation(String str){
        permutation(str, "");
    }

    //O(n*n!)
    static void permutation(String str, String prefix){
        System.out.println("prefix: "+prefix);
        if(str.length() == 0){
            System.out.println(prefix);
        }else{
            for(int i = 0; i < str.length(); i++){
                String rem = str.substring(0, i) + str.substring(i+1);
                System.out.println("rem: "+rem);
                permutation(rem, prefix + str.charAt(i));
            }
        }       
    }

    static void showHiddenFiles(){
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        File[] folders = new File(".").listFiles(File::isDirectory);
        for (File file : hiddenFiles) {
            System.out.println("File name: "+file.getName());
        }
    }
    
}
class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    } 

}
