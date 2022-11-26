package com.leetcode.design;

import java.util.Arrays;
import java.util.List;

final class ParkingSystem {
    private final List<Adder> adders;

    ParkingSystem(int big, int medium, int small) {
        this.adders = Arrays.asList(Adder.adder(big), Adder.adder(medium), Adder.adder(small));
    }

    boolean addCar(int carType) {
        if (carType > 0 && carType <= adders.size()) {
            return adders.get(carType - 1).add();
        }
        return false;
    }

    private static final class Adder {
        private final int capacity;
        private int size;

        private Adder(int capacity) {
            this.capacity = capacity;
            this.size = 0;
        }

        private static Adder adder(int capacity) {
            return new Adder(capacity);
        }

        boolean add() {
            if (size < capacity) {
                size++;
                return true;
            }
            return false;
        }
    }
}
