package com.company;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello World!");

        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};


        int n = (int) (Math.random() * 1000000);
        n *= 3;
        n += 0b1001;
        n += 0xFF;
        n *= 6;

        while (n >= 10) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                n /= 10;
                sum += digit;
            }
            n = sum;
        }

        System.out.printf("This semester I will learn " + languages[n]);
    }
}
