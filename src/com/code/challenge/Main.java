package com.code.challenge;

public class Main {

    public static void main(String[] args) {
        Lock lock = new Lock();
        String[] rings = {"241356789", "987546231", "956874231"};
        Integer rotationCount = lock.getRotationCount(3, "123", rings);
        System.out.println(rotationCount + " is needed to open the lock");
    }
}
