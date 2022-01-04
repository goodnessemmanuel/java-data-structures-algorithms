package com.ocheejeh.datastructures;

public class Stack {
    private int topIndex; //target index to be use for data manipulation
    private final int maxStackSize = 1_000; //this the maximum elements allowed in this stack
    private int[] stackContainer = new int[maxStackSize]; //initialize container;
    public Stack ()
    {
        topIndex = -1; //when nothing is in the stack
    }

    public boolean isEmpty()
    {
        return topIndex < 0; //indicates that stack is empty cause index cannot be -1
    }

    public boolean push(int valueToAddToStack)
    {
        if(topIndex >= maxStackSize - 1)
        {
            System.out.println("Stack overflow");
            return false;
        }
        else
        {
            stackContainer[++topIndex] = valueToAddToStack;
            return true;
        }
    }

    public int pop()
    {
        if(topIndex < 0)
        {
            System.out.println("Stack underflow");
            return 0;
        }
        else
        {
            int topElement = stackContainer[topIndex--];
            return topElement;
        }
    }
    public int peek()
    {
        if(topIndex < 0)
        {
            System.out.println("Stack underflow");
            return 0;
        }
        else
        {
            int topElement = stackContainer[topIndex];
            return topElement;
        }
    }
}
