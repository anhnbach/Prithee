package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTester {

    @Test
    void testCorrect() {
        assertEquals(true, Main.isCorrect("compare", 2));
    }

    @Test
    void testWrong() {
        assertEquals(false, Main.isCorrect("hello", 2));
    }

    @Test
    void testCapital() {
        assertEquals(true, Main.isCorrect("SHALL", 0));
    }

    @Test
    void testPunctuation() {
        assertEquals(true, Main.isCorrect("day", 7));
        assertEquals(true, Main.isCorrect("may", 23));
    }

    @Test
    void testSpaces() {
        assertEquals(true, Main.isCorrect("  compare  ", 2));
    }

    @Test
    void testEmptyGuess() {
        assertEquals(false, Main.isCorrect("", 0));
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