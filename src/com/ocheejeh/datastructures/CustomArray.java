package com.ocheejeh.datastructures;

public class CustomArray {
    //container variable to hold the array elements
    int[] hold;
    int countItem;
    //initialize the array using a constructor to specify the initial length
    int len;
    public CustomArray(int len){
        this.len = len;
        this.hold = new int[len];
        countItem = 0;
    }
    //method to insert element to the array
    public void insert(int item){
        if(countItem >= hold.length){
            int[] increaseHoldCapacity = new int[countItem + 1];
            for (int i = 0; i <hold.length; i++) {
                increaseHoldCapacity[i] = hold[i];
            }
            hold = increaseHoldCapacity;
        }
        hold[countItem] = item;
        countItem++;
    }
    public int indexOf(int item){
        for (int i = 0; i < hold.length; i++) {
            if(hold[i] == item){
                return i;
            }
        }
        return -1;
    }
    //time complexity of this method at all time is in the order of O(n)
    public void removeAt(int index){
        if(index > -1 && index < hold.length){
            int[] removeItem = new int[hold.length - 1];
            //[2, 3, 4, 5, 6] => [2, 3, 5, 6]
            for (int i = 0; i < removeItem.length; i++) {
                int currentItem  = hold[i];
                if(i >= index){
                    currentItem = hold[i + 1];

                }
                removeItem[i] = currentItem;
            }

            hold = removeItem;
            countItem--;
        } else {
            throw new IllegalArgumentException("index does not exist");
        }
    }
    public void removeAtV2(int index){
        if(index < 0 || index >= countItem) throw new IllegalArgumentException("index not in range");
        //runtime complexity best case O(1), worst case O(n)
        --countItem;
        for (int i = index; i < countItem; i++) {
            hold[i] = hold[i + 1];
        }
    }
    public void print(){
        for (int i = 0; i < countItem; i++) {
            System.out.print(hold[i] + " ");
        }
        System.out.println("array size is " + hold.length);
    }
}
