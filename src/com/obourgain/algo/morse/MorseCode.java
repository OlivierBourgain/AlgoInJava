package com.obourgain.algo.morse;

import java.util.*;

/**
 * Codingame janvier 2013.
 * <p/>
 * Problème 3
 * http://www.codingame.com/challenge_janvier_2013_question3
 *
 * @author obourgain
 */
public class MorseCode {

    /**
     * Table des caractères en morse.
     */
    static String[] tablemorse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
            "--.."};

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int n = in.nextInt();
        in.nextLine();
        List<String> dict = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            dict.add(s);
        }
        long res = calculeNbMessages(input, dict);


        System.out.println(res);
    }


    /**
     * Encode une chaine de caractère en morse.
     *
     * @param s La chaine à encoder.
     * @return La chaine encodée en morse.
     */
    static String encode(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++)
            res += tablemorse[s.charAt(i) - 'A'];
        return res;
    }

    /**
     * Calcule le nombre de messages qu'il est possible de générer à partir de la séquence en morse passée en paramètre.
     *
     * @param input La chaine en morse à décoder.
     * @param dict  Le dictionnaire.
     * @return Le nombre de messages.
     */
    public static long calculeNbMessages(String input, List<String> dict) {

        /**
         * dictmorse contient les mots du dictionnaire encodés en morse.
         * Comme plusieurs mots peuvent avoir la même représentation en morse,
         * dictmore est une Map dont la clé est la représentation en morse, et la
         * valeur le nombre de mots correspondants.
         */
        Map<String, Integer> dictmorse = new HashMap<String, Integer>();
        int maxlength = 0;
        for (String s : dict) {
            String morse = encode(s);
            if (morse.length() > maxlength) maxlength = morse.length();

            if (dictmorse.get(morse) == null) {
                dictmorse.put(morse, 1);
            } else {
                Integer val = dictmorse.get(morse);
                dictmorse.put(morse, val + 1);
            }

        }

        // On calcule la réponse pour chaque chaine de longueur 1 à input.length
        int l = input.length();
        long[] res = new long[l + 1];

        // La chaine de longueur 0 ("") ne correspond qu'à un seul message ("").
        res[0] = 1;

        for (int i = 1; i < l + 1; i++) {
            // Vérifie chaque mot qui se termine à l'indice i
            for (int j = max(0, i - maxlength); j < i; j++) {
                Integer k = dictmorse.get(input.substring(j, i));
                if (k != null) {
                    // la chaine entre j et i correspond à k mots du dictionnaire
                    res[i] += res[j] * k;
                }
            }
        }
        return res[l];
    }

    private static int max(int a, int b) {
        return a < b ? b : a;
    }

}