package com.ocheejeh.common;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws IOException {
  //      System.out.println("\ntotal steps: " +findSteps(3));
//        System.out.println(findSteps(4));
//        System.out.println(findSteps(5));
//        long largest = solution(new long[]{10, 100});
//        System.out.println(largest);
        System.out.println(reduceToBinaryTreeAndDetermineGreaterBranchCorrect(new long[]{3, 6, 2, 9, -1, 10}));
        System.out.println(reduceToBinaryTreeAndDetermineGreaterBranch(new long[]{3, 6, 2, 9, -1, 10}));

       // System.out.println(bin(new int[]{2, 3, 4,5, 6}, 0, 4, 5));

//        System.out.println(Arrays.toString(minOccuring(new int[]{1, 2, 2, 1, 3, 3, 4, 5, 5, 4, 1})));
        //System.out.println(Arrays.toString(printPrimeAndFib(7)));

        //testing permute sum elements to equals k
        //List<Integer> A = List.of(1, 3);
       /* List<Integer> A = Arrays.asList(1, 3);
        List<Integer> B = Arrays.asList(3, 1);
        System.out.println(twoArrays2( 4, A, B));

        List<Integer> C = Arrays.asList(1, 2, 2, 1);
        List<Integer> D = Arrays.asList(3 ,3, 3, 4);
        System.out.println(twoArrays2( 5, C, D));*/


        /*List<Integer> C = Arrays.asList(2 ,3, 1, 1, 1);
        List<Integer> D = Arrays.asList(1, 3, 4 ,3, 3);
        System.out.println(twoArrays( 5, C, D));


        List<Integer> E = Arrays.asList(1, 5, 1, 4, 4, 2, 7, 1, 2, 2);
        List<Integer> F = Arrays.asList(8, 7, 1, 7, 7, 4, 4, 3, 6, 7);
        System.out.println(twoArrays( 9, E, F));

        // just using a random test case
        List<Integer> P = Arrays.asList(1, 5, 1, 4, 4, 2, 7, 1, 2, 2, 2);
                                     //[1, 1, 1, 2, 2, 2, 4, 4, 5, 7]
        List<Integer> Q = Arrays.asList(8, 7, 7, 1, 7, 7, 4, 4, 3, 6, 7);
        System.out.println(twoArrays( 9, P, Q));
        //end random test case

        List<Integer> G = Arrays.asList(3, 6, 8, 5, 9, 9, 4, 8, 4, 7);
        List<Integer> H = Arrays.asList(5, 1, 0, 1, 6, 4, 1, 7, 4, 3);
        System.out.println(twoArrays( 9, G, H));

        List<Integer> I = Arrays.asList(4, 4, 3, 2, 1, 4, 4, 3, 2, 4);
        List<Integer> J = Arrays.asList(2, 3, 0, 1, 1, 3, 1, 0, 0, 2);
        System.out.println(twoArrays( 4, I, J));*/

        //balance point, expecting index of 5(i.e. 3) since 1 + 1+ 3 = 5 in both LHS, RHS
//        System.out.println("balance point: " + balancePoint(new int[]{1, 1, 3, 5, 1, 1, 3}));
//
//        System.out.println("Hackerrank api call response teamAPT ");
//        System.out.println(getDiscountPriceTeamAPTFromRestAPICall());
//        System.out.println("End hackerrank api call ");
//
//        List<Integer> integers = Arrays.asList(1, 3, 5, 6);
//        Integer[] array = new Integer[integers.size()];



    }

    public static long solution(long[] numbers) {
        // Type your solution here
        if(numbers.length < 1) return 0;
        long largestNum = numbers[0];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > largestNum){
                largestNum = numbers[i];
            }
        }
        return largestNum;
    }
    public static int bin(int[] arr, int l, int r, int x){
        if(r >= l){
            int mid = 1 + (r - l) / 2;
            if(arr[mid] == x)
                return mid;
            if(arr[mid] > x)
                return bin(arr, l, mid + l, x);

            return  bin(arr, mid + 1, r , x);
        }
        return  -1;
    }
    /**
     * Pre-order traversal visits first the root node, then the left sub-tree,
     * and finally the right sub-tree:
     */
    static void traversePreOrder(TreeNode.Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    public static String reduceToBinaryTreeAndDetermineGreaterBranch(long[] arr){
        int len = arr.length;
        if(len == 0 || len == 1) return "";

        /*Node rootNode = new Node(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            //left nodes are at 2 * i + 1;
            if(2 * i + 1 < arr.length) {
                rootNode = rootNode.add(rootNode, arr[2 * i + 1]);
            }
            if(2 * i + 2 < arr.length)
               rootNode = rootNode.addRight(rootNode, arr[2 * i + 2]);
        }*/
        TreeNode treeNode = new TreeNode();
        treeNode.insertInLevelOrder(arr, 0);
        traversePreOrder(treeNode.root);
        //long leftNodeSum = treeNode.addBT(treeNode.root.left);
        long leftNodeSum = 0;
        //long rightNodeSum = treeNode.getSum(treeNode.root.right);
        long rightNodeSum = 0;


        /*for (int i = 0; i < len; i++) {
            if(i + 1 < len && arr[i + 1] == -1) continue;
            if(i + 1 < len)
                leftNodeSum += arr[i + 1];
            if(i + 2 < len)
                rightNodeSum += arr[i + 2];
        }*/

        return leftNodeSum > rightNodeSum? "Left" : "Right";
    }

    /**
     * for more insight of what happened here, you can search online for the article:
     * "Comparing Left and Right Branch of a Complete Binary Tree"
     * @param arr
     * @return
     */
    public static String reduceToBinaryTreeAndDetermineGreaterBranchCorrect(long[] arr) {
        // Type your solution here
        int len = arr.length;
        if(len == 0 || len == 1) return "";
        long leftNodeSum = sum(arr, 2), rightNodeSum = sum(arr, 3);

        return leftNodeSum == rightNodeSum? "" : leftNodeSum > rightNodeSum? "Left" : "Right";
    }

    public static long sum(long[] arr, int idx){
        if(idx - 1 < arr.length){
            if(arr[idx - 1] == -1) return 0;
            return arr[idx -1] + sum(arr, idx * 2) +  sum(arr, idx * 2 + 1);
        }
        return 0;
    }
    /**
     * @param n
     * @return number of ways to climb steps
     * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
     * Implement a method to count how many possible ways the child can run up the stairs.
     *
     * Examples:
     *
     * Input : 4
     * Output : 7
     * Explanation:
     * Below are the seven ways
     *  1 step + 1 step + 1 step + 1 step
     *  1 step + 2 step + 1 step
     *  2 step + 1 step + 1 step
     *  1 step + 1 step + 2 step
     *  2 step + 2 step
     *  3 step + 1 step
     *  1 step + 3 step
     *
     * Input : 3
     * Output : 4
     * Explanation:
     * Below are the four ways
     *  1 step + 1 step + 1 step
     *  1 step + 2 step
     *  2 step + 1 step
     *  3 step
     *
     *
     */
    public static long findSteps(long n){
        if(n < 0) return 0;
        if(n == 0 ) return 1;
        long res3 = findSteps(n - 3);
        System.out.printf("n-3 call result: %d%n", res3);
        long res2 = findSteps(n - 2);
        System.out.printf("n-2 call result: %d%n", res2);
        long res1 = findSteps(n - 1);
        System.out.printf("n-1 call result: %d%n", res1);
        long sumSteps = res1 + res2 + res3;
        System.out.printf("sum steps for all 3 calls is: %d%n", sumSteps);
        return sumSteps;
    }

    //start

    public static int[] minOccuring(int[] array){

        //add numbers to result list

        List<Integer> result = new ArrayList<>();

        //count integer occuranes

        HashMap<Integer,Integer> elements = new HashMap<>();

        int minimum = Integer.MAX_VALUE;

        //calculate each element occurrence

        for (int i = 0; i < array.length; i++) {

            //if current number has already in map

            if(elements.containsKey(array[i])){

                //increment the count

                int numOccurances = elements.get(array[i]);

                elements.put(array[i],++numOccurances);

            } else {

                elements.put(array[i],1);

            }

        }


        //get how many times minimum number is occurred

        for (int i = 0; i < array.length; i++) {

            int numOccurances = elements.get(array[i]);

            if(numOccurances < minimum){

                minimum = numOccurances;

            }

        }


        //add minimum occuring elements to list

        for (int i = 0; i < array.length; i++) {

            int numOccurances = elements.get(array[i]);

            if(numOccurances==minimum){

            //if list has no minimum value

                if(!result.contains(array[i])){

                    result.add(array[i]);

                }

            }

        }


        // List to Array Conversion

        int[] arrayResult = new int[result.size()];

        for (int i =0; i < result.size(); i++)

            arrayResult[i] = result.get(i);

        return arrayResult;

    }


    //end

    static Boolean isSquare(long n){
        long res = (long)Math.sqrt(n);
        return (res * res == n);
    }

    /**
     * this approach fails most test cases use cheggs approach instead
     * @param n
     * @return
     */
    static long[] printPrimeAndFib(long n)
    {
        // Using Sieve to generate all
        // primes less than or equal to n.
        Boolean[] prime = new Boolean[(int)n + 1];

        // memset(prime, true, sizeof(prime));
        for (int p = 0; p <= n; p++)
            prime[p] = true;
        for (int p = 2; p * p <= n; p++) {

            // If prime[p] is not changed,
            // then it is a prime
            if (prime[p] == true) {

                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Now traverse through the range and
        // print numbers that are both prime
        // and Fibonacci.
        List<Long> primeFib = new ArrayList<>();
        for (int i=2; i<=n; i++) {
            double sqrt = Math.sqrt(5 * i * i + 4);
            double sqrt1 = Math.sqrt(5 * i * i - 4);

            int x = (int) sqrt;
            int y = (int) sqrt1;

            if (prime[i] && (Math.pow(sqrt,2) ==
                    Math.pow(x,2) || Math.pow(sqrt1,2) ==
                    Math.pow(y,2)))
                primeFib.add((long) i);
        }
        long[] primeFibLong = new long[primeFib.size()];
        for (int i = 0; i < primeFib.size(); i++) {
                primeFibLong[i] = primeFib.get(i);
        }
        if(primeFibLong.length == 1 && primeFibLong[0] ==  0){
            return new long[]{};
        }
        return primeFibLong;
    }

    /**
     * Complete the twoArrays function in the editor below.
     * It should return a string, either YES or NO.
     *
     * twoArrays has the following parameter(s):
     *
     * int k: an integer
     * int A[n]: an array of integers
     * int B[n]: an array of integers
     * Returns
     * - string: either YES or NO
     * @param k
     * @param A
     * @param B
     * @return
     *
     * here are two n-element arrays of integers, A and B. Permute them into some A' and B'
     * such that the relation |A'[i] + B'[i]| >= k holds for all i where 0 <= i < n.
     */
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        Collections.sort(A);
        int n = A.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(A.get(i) + B.get(j) >= k){
                    int temp = B.get(i);
                    B.set(i, B.get(j));
                    B.set(j, temp);
                    break;
                }
            }
        }
        System.out.println("k =" + k);
        System.out.println(A);
        System.out.println(B);
        System.out.println();
        for (int i = 0; i < n; i++) {
            if(A.get(i) + B.get(i) < k)
                return "NO";
        }
        return "YES";

    }

    /**
     * 44.1 Balance Point
     *
     * Given an integer array, write a method that looks for an element that is equal to the sum of the elements to its left and the sum of the elements to its right.
     * If such an element exists, return its index. Otherwise, return -1. (If multiple such elements exist, return the index of the first from the left.) For the first
     * element of the array, define the sum of the elements to its left as 0. For the last element, define the sum of the elements to its right as 0.
     *
     * Example: {1, 1, 3, 5, 1, 1, 3} should return 3 since 1+1+3 = 5.
     *
     * Hint: This requires a nested loop. One way to think about the inner loop is to consider whether each value should be added to a
     * leftSum or a rightSum (or not, since there has to be a middle value).
     * @param array
     * @return
     */
    public static int balancePoint(int[] array){
        //loop through each element of the array
        for (int i = 0; i < array.length; i++) {

            //calculating leftsum
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }

            if(array[i] == leftSum && array[i] == rightSum){
                return  i;
            }
        }

        return -1;
    }

    public static int getDiscountPriceTeamAPTFromRestAPICall(){
        try{
            String response = getResponseTeamAptHackerrank(74002314);

            System.out.println("Response: " + response);
            String[] splitResponse = response.split(",");
            for (int i = 0; i < splitResponse.length; i++) {
                if(splitResponse[i].contains("data")){
                    String data = splitResponse[i];
                    System.out.println("data found: " + data);
                    String[] splitData = data.split(",");
                    System.out.println("split data: " + Arrays.toString(splitData));
                }
                if(splitResponse[i].contains("discount")){
                    String discountData = splitResponse[i];
                    System.out.println("discount data found: " + discountData);
                    String[] splitDiscountData = discountData.split(":");
                    System.out.println("split data: " + Arrays.toString(splitDiscountData));
                    if(splitDiscountData.length == 2){
                        return Integer.parseInt(splitDiscountData[1]);
                    }
                }
            }
            return -1;

        }
        catch(IOException e){
            e.printStackTrace();
        }

        return  -1;
    }

    public static String getResponseTeamAptHackerrank(int barcode) throws IOException{
        URL url = new URL("https://jsonmock.hackerrank.com/api/inventory?barcode=" + barcode);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("Content-Type", "application/json");
        //InputStream is = connection.getInputStream();

        int status = connection.getResponseCode();

        if(status < 200 || status >= 300){
            System.out.println("Status code is: " + status);
            throw new IOException("Error reading data");
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response;
        StringBuilder builder = new StringBuilder();
        while ((response = bf.readLine()) != null){
            builder.append(response);
        }
        bf.close();
        connection.disconnect();

        return builder.toString();

    }

    public static String callRestAPIHackerrankIDE() throws IOException {
        //don't add s to http for precaution measure
        URL url = new URL("https://jsonmock.hackerrank.com/api/inventory?barcode=74002314");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("Content-Type", "application/json");
        //InputStream is = connection.getInputStream();

        int status = connection.getResponseCode();

        if(status < 200 || status >= 300){
            System.out.println("Status code is: " + status);
            throw new IOException("Error reading data");
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response;
        StringBuilder builder = new StringBuilder();
        while ((response = bf.readLine()) != null){
            builder.append(response);
        }
        bf.close();
        connection.disconnect();

        return builder.toString();

    }

    public static int birthday(List<Integer> integers, int d, int m){
        int numberOfSegments = 0;
        List<Integer> segments = new ArrayList<>(m);
        for (int i = 0; i < integers.size(); i++) {
            int nextValueSumIndex = indexOfNextSumValue(integers, integers.get(i), i + 1, d);
            if( nextValueSumIndex != -1){

            }
        }

        return numberOfSegments;
    }
    public static int indexOfNextSumValue(List<Integer> integers, int currentItem, int startIndex, int d){
        for (int i = startIndex; i < integers.size(); i++) {
            if (integers.get(i) + currentItem == d){
               return  i;
            }
        }

        return -1;
    }



}
class Node {
    long value;
    Node left;
    Node right;
    Node(long value){

        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree {
    Node root;
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current, value);
        } else if (value > current.value) {
            current.right = addRecursive(current, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }
    /**
     * The in-order traversal consists of first visiting the left sub-tree,
     * then the root node, and finally the right sub-tree:
     * @param node
     */
    void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    /**
     * Pre-order traversal visits first the root node, then the left sub-tree,
     * and finally the right sub-tree:
     */
    void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
}
class TreeNode {
   static class Node {
        long value;
        Node left;
        Node right;
        Node(long value){

            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    /**
     *
     * @param arr one dimensional to be converted to a tree structure
     * @param startIndex
     * @return
     */
    Node insertInLevelOrder(long[] arr, int startIndex){
        if(startIndex < arr.length) {
            root = new Node(arr[startIndex]);

            //insert left child
            root.left = insertInLevelOrder(arr, startIndex * 2 + 1);
            //insert right child
            root.right = insertInLevelOrder(arr, startIndex * 2 + 2);
        }

        return root;
    }

    long addBT(Node root)
    {
        if (root == null)
            return 0;
        return (root.value + addBT(root.left) +
                addBT(root.right));
    }

    /**
     * The in-order traversal consists of first visiting the left sub-tree,
     * then the root node, and finally the right sub-tree:
     * @param node
     */
    void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }


}
