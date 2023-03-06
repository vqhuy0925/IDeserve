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
    
}
class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    } 

}
