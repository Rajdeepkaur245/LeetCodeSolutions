/*
 * Q:1 Write a program explaining multiple threads working together to solve a problem:       
 *    1. Create a int[] DataArray of 100 elements with random numbers.
 *    2. Create 5 threads which take the part of elements from DataArray.
 *    3. Those threads should compute the Square[ ] and Cubes[ ] for those respective values.
 *    4. Print result of square and cubes after the all process threads complete their execution.
 *
 */

import java.util.*;
public class MultiThreadSquares {
    
    private static int[] initiliazeArray(int n) {
        int[] arr = new int[n];
        Random r = new Random();
        for (int i=0; i<n; i++) {
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }
    
    private static void printResult(int[] arr, int[] squares, int[] cubes) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Square of " + arr[i] + " is " + squares[i] + ".");
            System.out.println("Cube of " + arr[i] + " is " + cubes[i] + ".");
            System.out.println();
        }
    }

     public static void main(String []args) throws InterruptedException {
        int n = 100, threadCount = 5;
        
        int[] arr = initiliazeArray(n);
        
        int[] squares = new int[n];
        int[] cubes = new int[n];
        
        ComputeThread[] threadArray = new ComputeThread[Math.min(threadCount, n)];
    
        int start = 0;
        int rangeSize = (int) Math.ceil((double) n / threadArray.length);
        for(int i = 0; i < threadArray.length; i++) {
            int end = start + rangeSize - 1;
            threadArray[i] = new ComputeThread(arr, squares, cubes, start, Math.min(end, n - 1));
            start = end + 1;
            threadArray[i].start();
        }
        
        for(int i = 0; i< threadArray.length; i++) {
            threadArray[i].join();
        }
        
        printResult(arr, squares, cubes);
     }
}

class ComputeThread extends Thread {
    int start, end;
    int[] arr;
    int[] squares;
    int[] cubes;
    
    ComputeThread(int[] arr, int [] squares, int [] cubes, int start, int end) {
        this.arr = arr;
        this.squares = squares;
        this.cubes = cubes;
        this.start = start;
        this.end = end;
    }
    
    public void run() {
        for(int i = start; i <= end; i++) {
            squares[i] = arr[i] * arr[i];
            cubes[i] = arr[i] * arr[i] * arr[i];
        }    
    }
    
}