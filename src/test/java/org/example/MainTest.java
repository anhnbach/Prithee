package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void testCorrect() {
        assertTrue(Main.isCorrect("compare", 2));
    }

    @Test
    void testWrong() {
        assertFalse(Main.isCorrect("hello", 2));
    }

    @Test
    void testCapital() {
        assertTrue(Main.isCorrect("SHALL", 0));
    }

    @Test
    void testPunctuation() {
        assertTrue(Main.isCorrect("day", 7));
        assertTrue(Main.isCorrect("may", 23));
    }

    @Test
    void testSpaces() {
        assertTrue(Main.isCorrect("  compare  ", 2));
    }

    @Test
    void testEmptyGuess() {
        assertFalse(Main.isCorrect("", 0));
    }

    @Test
    void testFirstWord() {
        assertEquals("Shall", Main.words[0]);
    }

    @Test
    void testLastWord() {
        assertEquals("thee.", Main.words[113]);
    }

    @Test
    void testWordCount() {
        assertEquals(114, Main.words.length);
    }

    @Test
    void testStopAtFirstWord() {
        assertEquals("_____", Main.textUpTo(0));
    }

    @Test
    void testUnderscoreLength() {
        assertEquals("Shall I compare thee to a summer's ___", Main.textUpTo(7));
    }

    @Test
    void testStopOnNewLine() {
        assertEquals("Shall I compare thee to a summer's day? \n____", Main.textUpTo(8));
    }
}