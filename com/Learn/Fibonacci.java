package com.Learn;

import static java.lang.System.out;

/**
 * Class that represents Fibonacci series.
 * It build series from value 'a' to value 'b'
 * using Fibonacci rule.
 */
public class Fibonacci {
    private int a, b;
    private int fib_len;

    Fibonacci(){
        a = 1;
        b = 10;
        fib_len = 0;
    }

    Fibonacci(int a, int b, int len){
        this.a = a;
        this.b = b;
        fib_len = len;
    }

    public void initInterval(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void initLen(int len){
        fib_len = len;
    }

    /**
     * Prints interval in which to build series
     */
    public void printInterval(){
        out.format("Interval is [%d;%d]\n", a, b);
    }

    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public int getFib_len(){
        return fib_len;
    }

    /**
     * Function that builds and returns array which
     * contains each element of the series.
     *
     * It`s first two elements are:
     * 1) the largest odd number
     * 2) the largest even number
     * That were taken from interval from 'a' to 'b'
     */
    public int[] buildSeries(){

        int x1, x2;
        // operation to check whether the last value of the interval is even or not
        int even_checker = b&1;

        // if it is, put this value to the second position in series
        if(even_checker==0){
            x2 = b;
            x1 = b-1;
            // else put value-1 to second pos.
        }else{
            x1 = b;
            x2 = b-1;
        }

        // array which will contain each element of the series
        int[] series = new int[fib_len];
        // fill two first elements according to the task
        series[0] = x1; series[1] = x2;

        for (int i = 2; i < fib_len; i++) {
            // building each element of the series
            series[i] = series[i-1] + series[i-2];
        }

        // return array with the series
        return series;
    }
}
