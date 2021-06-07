package com.code.challenge;

public class Lock {

    public static int INITIAL_INDEX = 0;

    public Integer getRotationCount(Integer digitCount, String password, String[] rings) {
        if (digitCount != password.length() || rings.length != digitCount) {
            throw new IllegalArgumentException("inputs are not in valid format");
        }
        int rotationCount = 0;
        for (int charIndex = 0; charIndex < digitCount; charIndex++) {
            String ring = getCurrentRing(charIndex, rings);
            rotationCount += calculateRotations(charIndex, password, ring);
        }
        return rotationCount;
    }

    private int calculateRotations(int charIndex, String password, String ringString) {
        char[] ring = ringString.toCharArray();
        Integer currentIndex = getCurrentCharIndexOnRing(password.toCharArray()[charIndex], ring);
        if (isCharOnFirstHalfRing(ring, currentIndex)) {
            return currentIndex - INITIAL_INDEX;
        } else {
            return ring.length - currentIndex;
        }
    }

    private boolean isCharOnFirstHalfRing(char[] ring, Integer currentIndex) {
        return currentIndex <= (ring.length / 2);
    }

    private Integer getCurrentCharIndexOnRing(char passwordDigit, char[] ring) {
        for (int index = 0; index < ring.length; index++) {
            if (ring[index] == passwordDigit)
                return index;
        }
        throw new IllegalStateException("weird password Digit not exists on ring");
    }

    private String getCurrentRing(int charIndex, String[] rings) {
        return rings[charIndex];
    }

}
