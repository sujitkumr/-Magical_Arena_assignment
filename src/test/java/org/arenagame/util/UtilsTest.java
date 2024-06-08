package org.arenagame.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

    @Test
    void testRollDice() {
        // Roll the dice 1000 times to ensure it always returns within the expected range
        for (int i = 0; i < 1000; i++) {
            int result = Utils.rollDice();
            assertTrue(result >= 1 && result <= 6, "Dice roll should be between 1 and 6, but got " + result);
        }
    }
}