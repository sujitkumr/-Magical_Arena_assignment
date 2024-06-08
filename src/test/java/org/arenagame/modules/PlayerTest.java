package org.arenagame.modules;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerCreation() {
        Player player = new Player(1, "Hero", 100, 20, 15);

        assertEquals(1, player.getId());
        assertEquals("Hero", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(20, player.getStrength());
        assertEquals(15, player.getAttack());
    }

    @Test
    void testSetId() {
        Player player = new Player(1, "Hero", 100, 20, 15);
        player.setId(2);
        assertEquals(2, player.getId());
    }

    @Test
    void testSetName() {
        Player player = new Player(1, "Hero", 100, 20, 15);
        player.setName("Warrior");
        assertEquals("Warrior", player.getName());
    }

    @Test
    void testSetHealth() {
        Player player = new Player(1, "Hero", 100, 20, 15);
        player.setHealth(90);
        assertEquals(90, player.getHealth());
    }

    @Test
    void testSetStrength() {
        Player player = new Player(1, "Hero", 100, 20, 15);
        player.setStrength(25);
        assertEquals(25, player.getStrength());
    }

    @Test
    void testSetAttack() {
        Player player = new Player(1, "Hero", 100, 20, 15);
        player.setAttack(10);
        assertEquals(10, player.getAttack());
    }
}