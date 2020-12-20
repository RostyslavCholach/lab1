package com.Learn;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

// Cholach Rostyslav


public class Main {

    public static void main(String[] args) {

        String start_message = "This is the first lab exercise!\n";
        out.println(start_message);

        out.println("These are the parameters of func. main:\n");
        for (String i : args){
            out.println(i);
        }

        out.println("\nInitialization check:");
        InitCheck object = new InitCheck();
        out.format("x = %d, y = %c\n\n", object.x, object.y);

        Fibonacci series = new Fibonacci();
        Scanner scanner = new Scanner(in);
        out.println("Enter interval [a;b]:");

        int a,b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        series.initInterval(a, b);
        series.printInterval();

        out.println("\nEnter Fibonacci series length:");

        // Length of the Fibonacci series
        int fslen = scanner.nextInt();

        series.initLen(fslen);

        descendingPrintEvenNums(series);
        enhancingPrintOddNums(series);

        out.println("\n");

        out.println("Sum of even nums and odd nums = " + sumOfInterval(series.getA(), series.getB()) + "\n");

        int[] fibSeries = series.buildSeries();
        out.println("Fibonacci series:");
        for (int element : fibSeries) out.format("%d ", element);

        int even_quantity = 0, odd_quantity = 0;

        for (int i = 0; i < fslen; i++) {
            int checker = fibSeries[i]&1;
            if(checker == 0) even_quantity++; else odd_quantity++;
        }

        out.format("\neven percentage - %.2f%%\nodd percentage - %.2f%%", ((double)even_quantity/fslen)*100, ((double)odd_quantity/fslen)*100);

    }

    static class InitCheck{
        int x;
        char y;
    }

    /**
     * Function that prints even numbers in descending order.
     * It uses Binary Multiplication to find out whether number is even or not.
     */
    public static void descendingPrintEvenNums(Fibonacci obj){
        out.println("\nAll even numbers in descending order:");
        for (int i = obj.getB(); i >= obj.getA(); i--) {
            int checker = i&1;
            if(checker == 0) out.print(i + " ");
        }
    }

    /**
     * Function that prints even numbers in enhancing order.
     * It uses Binary Multiplication to find out whether number is odd or not.
     */
    public static void enhancingPrintOddNums(Fibonacci obj){
        out.println("\nAll odd numbers in enhancing order:");
        for (int i = obj.getA(); i <= obj.getB(); i++) {
            int checker = i&1;
            if(checker == 1) out.print(i + " ");
        }
    }

    /**
     * Function that evaluate sum from number 'a' to number 'b'.
     * It evaluates sum by using simple for-loop from 'a' to 'b'.
     */
    public static int sumOfInterval(int start, int end){
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum+=i;
        }
        return sum;
    }

}

