package com.cooksys.ftd.assignments.control;

import com.cooksys.ftd.assignments.control.util.MissingImplementationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two elements are `1`, and
 * every other element is equal to the sum of its two preceding elements. For example:
 * <p>
 * [1, 1] =>
 * [1, 1, 1 + 1]  => [1, 1, 2] =>
 * [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] =>
 * ...etc
 */
public class Fibonacci {

    /**
     * Calculates the value in the Fibonacci sequence at a given index. For example,
     * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two elements of the
     * sequence are both `1`.
     *
     * @param i the index of the element to calculate
     * @return the calculated element
     * @throws IllegalArgumentException if the given index is less than zero
     */
    public static int atIndex(int i) throws IllegalArgumentException {
        if(i < 0){
            throw new IllegalArgumentException();
        }
        //Calls the fibonacci function to create a sequence.
        int [] fibonacciArray = fibonacci(i+1);
        //Extract just using the index
        return fibonacciArray[i];
    }

    /**
     * Calculates a slice of the fibonacci sequence, starting from a given start index (inclusive) and
     * ending at a given end index (exclusive).
     *
     * @param start the starting index of the slice (inclusive)
     * @param end   the ending index of the slice(exclusive)
     * @return the calculated slice as an array of int elements
     * @throws IllegalArgumentException if either the given start or end is negative, or if the
     *                                  given end is less than the given start
     */
    public static int[] slice(int start, int end) throws IllegalArgumentException {
        if(start < 0  || end < 0 || end < start){
            throw new IllegalArgumentException();
        }
        //Invokes the fibonacci method to create a sequence and puts it in a new array.
        int [] fibonacciArray = fibonacci(end + 1);

        //Creating a new int array with the size.
        int [] sliceArray = new int[end - start];

        //Only iterating through the size of the new array
        for (int i = 0; i < sliceArray.length ; i ++){
            //Replaces the values respectively with the index.
            //The index increases when i increases.
            sliceArray[i] = fibonacciArray[start + i];
        }

        return sliceArray;
    }

    /**
     * Calculates the beginning of the fibonacci sequence, up to a given count.
     *
     * @param count the number of elements to calculate
     * @return the beginning of the fibonacci sequence, up to the given count, as an array of int elements
     * @throws IllegalArgumentException if the given count is negative
     */
    public static int[] fibonacci(int count) throws IllegalArgumentException {
        if(count < 0){
            throw new IllegalArgumentException();
        }

        int startOne = 1;
        int startTwo =1;


        if(count == 0){
          return new int[] {};
        } else if(count == 1){
            return new int[] {startOne};
        } else if (count == 2) {
            return new int[] {startOne,startTwo};
        }else {
            //Created an array list because it is easier to manipulate
            List<Integer> fibonacciList = new ArrayList<Integer>();

            //Added the first two values with their respective indices
            fibonacciList.add(0,startOne);
            fibonacciList.add(1,startTwo);

            for(int i = 2 ; i < count; i ++){
                //i starts at 2 because it is referring to the index.
                //First iteration -> current fibonacciList = {1,1}
                //i = 2
                //fibonacciList.get(2-2) --> fibonacciList.get(0) --> 1
                //fibonacciList.get(2-1) --> fibonacciList.get(1) --> 1
                // 1 + 1 = 2
                //first 2 represents the index
                //second 2 represents the value
                //fibonacciList.add(2,2)
                fibonacciList.add(i, (fibonacciList.get(i-2) + fibonacciList.get(i-1)));
            }

            //Need to convert it back into an int [] array so created a new int []
            int [] fibonacciArray = new int[fibonacciList.size()];

            //For loop to put all the new values into the new int []
            for(int i = 0 ; i < fibonacciList.size() ; i ++){
                fibonacciArray[i] = fibonacciList.get(i);
            }

            return fibonacciArray;
        }
    }
}
