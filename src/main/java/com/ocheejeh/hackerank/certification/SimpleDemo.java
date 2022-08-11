package com.ocheejeh.hackerank.certification;

public class SimpleDemo implements Runnable{
    private Thread t;
    private String threadName;
    public SimpleDemo(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        while (true){
            System.out.print(threadName);
        }
    }
    public void start(){
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
