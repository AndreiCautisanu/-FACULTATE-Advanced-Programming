package com.company;

import java.util.Arrays;
import java.util.Random;

public class Problem2 {

    private static int indexOf(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private static int maximum(int[] array) {
        int maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximum) {
                maximum = array[i];
            }
        }
        return maximum;
    }

    private static int minimum(int[] array) {
        int minimum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        return minimum;
    }

    private static boolean commonLetter(StringBuilder word1, StringBuilder word2) {
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static StringBuilder randomWord(int len, char[] alphabet) {
        StringBuilder word = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            int letter = random.nextInt(alphabet.length);
            word.append(alphabet[letter]);
        }
        return word;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int alphabetLength = args.length - 2;
        char alphabet[] = new char[alphabetLength];

        for (int i = 0; i < alphabetLength; i++) {
            alphabet[i] = args[i+2].charAt(0);
        }

        StringBuilder words[] = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            words[i] = randomWord(k, alphabet);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }

        boolean matrix[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = commonLetter(words[i], words[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", matrix[i][j] ? 1 : 0);
            }
            System.out.println();
        }

        int noOfNeighbors[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                noOfNeighbors[i] += matrix[i][j] ? 1 : 0;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(noOfNeighbors[i]);
        }

        System.out.println();
        System.out.println();
        System.out.println(words[indexOf(noOfNeighbors, maximum((noOfNeighbors)))]);
        System.out.println(words[indexOf(noOfNeighbors, minimum((noOfNeighbors)))]);
    }
}
