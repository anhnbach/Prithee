package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static String[] sonnet = {
            "Shall I compare thee to a summer's day?",
            "Thou art more lovely and more temperate:",
            "Rough winds do shake the darling buds of May,",
            "And summer's lease hath all too short a date;",
            "Sometime too hot the eye of heaven shines,",
            "And often is his gold complexion dimm'd;",
            "And every fair from fair sometime declines,",
            "By chance or nature's changing course untrimm'd;",
            "But thy eternal summer shall not fade,",
            "Nor lose possession of that fair thou ow'st;",
            "Nor shall death brag thou wander'st in his shade,",
            "When in eternal lines to time thou grow'st:",
            "So long as men can breathe or eyes can see,",
            "So long lives this, and this gives life to thee."
    };

    static String[] words = String.join(" ", sonnet).split(" ");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int correct = 0;
        int wrong = 0;
        int lastIndex = -1;

        while (correct < 3 && wrong < 3) {
            // pick a different random word
            int index = random.nextInt(words.length);
            while (index == lastIndex) {
                index = random.nextInt(words.length);
            }
            lastIndex = index;

            // print the sonnet up to the missing word
            System.out.println(textUpTo(index));
            System.out.print("What is the next word? ");
            String guess = scanner.nextLine();

            // right guess, add 1 to correct counter
            if (isCorrect(guess, index)) {
                System.out.println("Correct!");
                correct = correct + 1;
            }
            // wrong guess, add 1 to wrong counter
            else {
                System.out.println("Error! The word was: " + wordToGuess(index));
                wrong = wrong + 1;
            }
            System.out.println();
        }

        // print out result for player to check
        System.out.println("Game over. Correct: " + correct + ", Wrong: " + wrong);
    }

    // returns the sonnet up to the word at index
    static String textUpTo(int index) {
        // one underscore for each letter of the word
        String underscores = "_".repeat(wordToGuess(index).length());
        String text = "";
        int count = 0;
        // print out sonnet + next word in underscore
        for (int i = 0; i < sonnet.length; i++) {
            String[] lineWords = sonnet[i].split(" ");
            for (int j = 0; j < lineWords.length; j++) {
                if (count == index) {
                    return text + underscores;
                }
                text = text + lineWords[j] + " ";
                count = count + 1;
            }
            text = text + "\n";
        }
        return text;
    }

    // returns the word at index without the punctuation at the end
    static String wordToGuess(int index) {
        String word = words[index];
        char last = word.charAt(word.length() - 1);
        if (!Character.isLetter(last)) {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }

    // checks the guess
    static boolean isCorrect(String guess, int index) {
        return guess.trim().equalsIgnoreCase(wordToGuess(index));
    }
}