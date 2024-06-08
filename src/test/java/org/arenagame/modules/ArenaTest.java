package org.arenagame.modules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena();
    }

    @Test
    void testAddPlayer() {
        int playerId = arena.addPlayer("Test Player", 100, 10, 10);
        assertTrue(arena.isPresent(playerId));
    }

    @Test
    void testAddPlayerWithInvalidStats() {
        int playerId = arena.addPlayer("Weak Player", -1, -1, -1);
        assertEquals(-1, playerId);
    }

    @Test
    void testPlayerCount() {
        assertEquals(0, arena.getPlayerCount());
        arena.addPlayer("Test Player 1", 100, 10, 10);
        arena.addPlayer("Test Player 2", 100, 10, 10);
        assertEquals(2, arena.getPlayerCount());
    }

    @Test
    void testDeletePlayer() {
        int playerId = arena.addPlayer("Test Player", 100, 10, 10);
        assertTrue(arena.isPresent(playerId));
        arena.deletePlayer(playerId);
        assertFalse(arena.isPresent(playerId));
    }

    @Test
    void testBattle() {
        int firstPlayerId = arena.addPlayer("Player One", 100, 10, 10);
        int secondPlayerId = arena.addPlayer("Player Two", 100, 10, 10);
        assertDoesNotThrow(() -> arena.battle(firstPlayerId, secondPlayerId));
    }
}