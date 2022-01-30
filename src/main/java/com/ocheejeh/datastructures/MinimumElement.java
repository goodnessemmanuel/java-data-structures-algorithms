package com.ocheejeh.datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {
    private static Scanner scanner = new Scanner(System.in);

    public static int findMin(int[] elements){
        int min = elements[0];
        for (int i = 1; i < elements.length; i++)
            if(min > elements[i]) min = elements[i];

        return min;

    }

    public static int findMinV2(int[] elements){
        Arrays.sort(elements);
        return elements[0];
    }

    public static int[] readElements(int integer){
        int[] elements = new int[integer];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = scanner.nextInt();
        }
        return elements;
    }

    public static int readInteger(){
        System.out.println("Enter an integer that represents array size \r");
        int size = scanner.nextInt(); // you can add try catch here for validation
        return size;
    }

}
