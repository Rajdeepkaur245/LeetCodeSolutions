import java.util.*;
public class MultiThreadSquares{
    
    private static int[] initiliazeArray(int n) {
        int[] arr = new int[n];
        Random r = new Random();
        for (int i=0; i<n; i++) {
            arr[i] = r.nextInt(10);
        }
        return arr;
    }

     public static void main(String []args) throws InterruptedException{
        int n = 100;
        int[] arr = initiliazeArray(n);
        
        int[] squares= new int[n];
        int[] cubes = new int[n];
        
        int threadCount = 3;
        ComputeThread[] threadArray = new ComputeThread[Math.min(threadCount, n)];
        
        int start = 0;
        int rangeSize = (int) Math.ceil((double) n / threadArray.length);
        for(int i = 0; i < threadArray.length; i++) {
            int end = start + rangeSize - 1;
            threadArray[i] = new ComputeThread(arr, squares, cubes, start, Math.min(end, n));
            start = start + rangeSize;
            threadArray[i].start();
        }
        
        for(int i = 0; i< threadArray.length; i++) {
            threadArray[i].join();
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Square of " + arr[i] + " is " + squares[i] + ".");
            System.out.println("Cube of " + arr[i] + " is " + cubes[i] + ".");
            System.out.println();
        }
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