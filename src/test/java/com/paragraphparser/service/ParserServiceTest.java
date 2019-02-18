package com.paragraphparser.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ParserServiceTest {

    private ParserServiceImpl parserService = new ParserServiceImpl();

    @Test
    public void shouldParseNullCase() {
        String input = null;
        String expected = null;

        String result = parserService.parse(input);

        assertEquals(expected, result);
    }

    @Test
    public void shouldParseSimpleCase() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        String expected = "abcdefghijklmnopqrstuvwxyz";

        String result = parserService.parse(input);

        assertEquals(expected, result);
    }

    @Test
    public void shouldParseBackwardsUpperCase() {
        String input = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String expected = "abcdefghijklmnopqrstuvwxyz";

        String result = parserService.parse(input);

        assertEquals(expected, result);
    }

    @Test
    public void shouldParseSpacesAndSpecialCase() {
        String input = "! @ # $ % & * \\ \b ( \n ) _ + 1 2 ≈ßå¬∂ƒ∫øœƒ";
        String expected = "";

        String result = parserService.parse(input);

        assertEquals(expected, result);
    }

    @Test
    public void shouldParseGivenCase() {
        String input = "When not studying nuclear physics, Bambi likes to play\n" +
                "beach volleyball.";

        String expected = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy";

        String result = parserService.parse(input);

        assertEquals(expected, result);
    }
}
