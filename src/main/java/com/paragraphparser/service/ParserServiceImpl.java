package com.paragraphparser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParserServiceImpl implements ParserService {

    private static Logger LOG = LoggerFactory.getLogger(ParserServiceImpl.class);

    private static int LOWERCASE_OFFSET = 97;
    private static int UPPERCASE_OFFSET = 65;
    private static int LETTERS = 26;

    @Override
    public String parse(String line) {
        LOG.info("Parsing: {}", line);

        if (line == null) {
            return null;
        }

        return letterCountingSort(line);
    }

    /**
     * Use a counting sort to count each letter in the line
     * then create the output with those counts.
     *
     * @param line
     * @return The letters of the given line in order.
     */
    private String letterCountingSort(String line) {
        // Create an array to store the count of each of the 26 letters.
        int[] letterCount = new int[LETTERS];

        // Loop over each char in the String
        // Convert them to ints to get the ascii value
        // Increase the appropriate letter's index by 1
        int totalLetters = 0;
        for (char lineChar : line.toCharArray()) {
            int ascii = (int) lineChar;

            if (ascii >= 97 && ascii <= 122) {
                // a - z chars have an ascii value of 97 - 122
                letterCount[getCountIndex(ascii, LOWERCASE_OFFSET)]++;
                totalLetters++;
            } else if (ascii >= 65 && ascii <= 90) {
                // A - Z chars have an ascii value of 65 - 90
                letterCount[getCountIndex(ascii, UPPERCASE_OFFSET)]++;
                totalLetters++;
            }
        }

        StringBuilder builder = new StringBuilder(totalLetters);
        // Loop over the letter counts to reconstruct the line in order
        for (int i = 0; i < LETTERS; i++) {
            if (letterCount[i] > 0) {
                // convert the array index to a lower case letter
                char letter = (char) (i + LOWERCASE_OFFSET);

                // Append letters to match the count
                for (int x = 0; x < letterCount[i]; x++) {
                    builder.append(letter);
                }
            }
        }

        return builder.toString();
    }

    /**
     * Get the count index for the given letter's ascii value
     *
     * @param asciiValue
     * @param offset
     * @return countIndex
     */
    private int getCountIndex(int asciiValue, int offset) {
        return asciiValue - offset;
    }
}
