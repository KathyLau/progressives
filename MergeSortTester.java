/*======================================
  class MergeSortTester
  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>
  BIG-OH CLASSIFICATION OF ALGORITHM:
    O(n*log(n))
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 1.9 deciseconds
  n=10      time: 2.3 deciseconds
  n=100     time: 5.7 deciseconds
  ...
  n= 10000  time: 830 deciseconds
  ANALYSIS:
  Though the data doesn't quite match up with the hypothesis that the
  runtime for mergesort is n * log(n), it seems to roughly follow the right
  pattern.
  ======================================*/

public class MergeSortTester
{

    /******************************
     * execution time analysis
     * <INSERT YOUR DESCRIPTION HERE OF
     *  YOUR APPARATUS FOR GENERATING EXECUTION
     *  TIME DATA...>
     ******************************/
     public static void main( String[] args ) {
       int n; // data size
       try { n = Integer.parseInt( args[0] );}
       catch (Exception e){n = 100;} //default size set to 100

         int[] a = new int[n]; //populate new array randomly
         for ( int i = 0; i < a.length; i++ ){
           a[i] = (int) ( Math.random() * a.length );}

         long[] trials = new long[10]; // calculate runtimes of 10 trials
        for ( int i = 0; i < trials.length; i++ ){
           long beg = System.nanoTime();
           MergeSort.sort(a);
           long end = System.nanoTime();
           trials[i] = end - beg;
        }
       System.out.println( "Mergsort of size" + n + " takes approx. : \t" + ( mean(trials) / 100000.0 ) + " deciseconds");

  }//end main

//average time
  public static long mean(long[] a){
    long time = 0;
    for ( int i = 0; i < a.length; i++ ){
      time += a[i];}
   return time / a.length;
 }

}//end class
