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
  n=100     time: 5.77 deciseconds
   ...
  n=1000    time: 88.8 deciseconds
  n= 10000  time: 830 deciseconds
  ANALYSIS:
  Pretty solid. It followed the induction proof.
  However, the times can vary a little, as expected and
  throw off the expected ratio slightly...
   ======================================*/

public class MergeSortTester
{

    /******************************
     * execution time analysis
     * create array to store ten runtimes
     * populate an array randomly and store its runtime in the array from the prev. step
     * return the mean of the runtimes
     ******************************/
     public static void main( String[] args ) {
       int n; // data size
       try { n = Integer.parseInt( args[0] );}
       catch (Exception e){n = 100;} //default size set to 100

         long[] trials = new long[10]; // calculate runtimes of 10 trials
        for ( int i = 0; i < trials.length; i++ ){
           int[] a = pop(n);
           long beg = System.nanoTime();
           MergeSort.sort(a);
           long end = System.nanoTime();
           trials[i] = end - beg;
        }
       System.out.println( "Rergsort of size" + n + " takes approx. : \t" + ( mean(trials) / 100000.0 ) + " deciseconds");

  }//end main

  public static int[] pop(int n){
int[] a = new int[n];
for ( int i = 0; i < a.length; i++ ){
   a[i] = (int) ( Math.random() * a.length );}
return a;}

  //average time
    public static long mean(long[] a){
      long time = 0;
      for ( int i = 0; i < a.length; i++ ){
        time += a[i];}
     return time / a.length;}

}//end class
