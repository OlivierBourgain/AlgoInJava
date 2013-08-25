package com.obourgain.algo.morse;

import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MorseCodeTest {

    @Test
    public void simpleTest() {
        String s = "...";
        List<String> dict = new ArrayList<String>();
        dict.add("E");
        dict.add("S");
        dict.add("I");
        assertEquals(4, MorseCode.calculeNbMessages(s, dict));
    }

    @Test
    public void testEncodingInMorse() {
        assertEquals(".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..",
                MorseCode.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }


    @Test
    public void testCas1() {
        InputStream is = MorseCodeTest.class.getResourceAsStream("test1.txt");
        Scanner in = new Scanner(is);
        String input = in.nextLine();

        List<String> dict = parseDictionnaire(in);

        assertEquals(1, MorseCode.calculeNbMessages(input, dict));
    }

    @Test
    public void testCas2() {
        InputStream is = MorseCodeTest.class.getResourceAsStream("test2.txt");
        Scanner in = new Scanner(is);
        String input = in.nextLine();

        List<String> dict = parseDictionnaire(in);

        assertEquals(1, MorseCode.calculeNbMessages(input, dict));
    }

    @Test
    public void testCas3() {
        InputStream is = MorseCodeTest.class.getResourceAsStream("test3.txt");
        Scanner in = new Scanner(is);
        String input = in.nextLine();

        List<String> dict = parseDictionnaire(in);

        assertEquals(2, MorseCode.calculeNbMessages(input, dict));
    }

    @Test
    public void testCas4() {
        InputStream is = MorseCodeTest.class.getResourceAsStream("test4.txt");
        Scanner in = new Scanner(is);
        String input = in.nextLine();

        List<String> dict = parseDictionnaire(in);

        assertEquals(2, MorseCode.calculeNbMessages(input, dict));
    }

    @Test
    public void testCas5() {
        InputStream is = MorseCodeTest.class.getResourceAsStream("test5.txt");
        Scanner in = new Scanner(is);
        String input = in.nextLine();

        List<String> dict = parseDictionnaire(in);

        assertEquals(1, MorseCode.calculeNbMessages(input, dict));
    }

    @Test
    public void testLargeDataset() {
        InputStream is = MorseCodeTest.class.getResourceAsStream("test_large.txt");
        Scanner in = new Scanner(is);
        String input = in.nextLine();

        List<String> dict = parseDictionnaire(in);

        assertEquals(57330892800L, MorseCode.calculeNbMessages(input, dict));
    }

    private List<String> parseDictionnaire(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        List<String> dict = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            dict.add(s);
        }
        return dict;
    }
}
