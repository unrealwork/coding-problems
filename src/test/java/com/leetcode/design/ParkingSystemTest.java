package com.leetcode.design;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingSystemTest {
    @Test
    @DisplayName("test ParkingSystem functionality")
    void test() {
        ParkingSystem system = new ParkingSystem(1, 2, 0);
        assertFalse(system.addCar(3));
        assertTrue(system.addCar(1));
        assertFalse(system.addCar(1));
        assertFalse(system.addCar(4));
    }
}
