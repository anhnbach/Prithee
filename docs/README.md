# Prithee

CS 3140 Homework 2

The program prints Sonnet 18 up to a random word, shows underscores in place
of that word, and asks the user to guess it. It says if the guess is correct
or an error, then restarts the sonnet at a different word. The game ends after
3 correct or 3 wrong guesses.

## How to Run

Requires Java 26. From the project folder:

```
./gradlew run -q --console=plain
```

On Windows, use `gradlew.bat` instead of `./gradlew`.

## How to Test

```
./gradlew test
```

## Design

All the code is in `Main.java`.

The sonnet is stored as an array of lines called `sonnet`, and as an array of
all its words called `words`.

`main` runs the game. Each round it picks a random word that is different from
the last one, prints the sonnet up to that word, and reads the user's guess.
It adds 1 to the correct or wrong count, and the loop stops when either one
reaches 3.

`textUpTo` returns the sonnet up to the chosen word, with one underscore for
each letter of that word.

`wordToGuess` returns the chosen word without the punctuation at the end, so
"day?" becomes "day".

`isCorrect` checks the guess against `wordToGuess`, ignoring capital letters
and extra spaces.

## Tests

The tests are in `MainTest.java`. They check that:

- right and wrong guesses are handled correctly
- capital letters, punctuation, extra spaces, and empty guesses are handled
- the words array has the right first word, last word, and word count
- the sonnet stops at the right place with the right number of underscores,
  including at the start of a new line