package com.test;

public class BaseWaitTime {
    public static void waitTime(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
