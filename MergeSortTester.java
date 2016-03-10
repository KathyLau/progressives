/*======================================
  class MergeSortTester
  ALGORITHM:
  <<MergeSort>>
    1. If array size == 1, array is sorted
    2. Else split array in half and recurse on each half
    3. When each of those halves is returned sorted, merge them.
       (Continually append smaller val from front of each half to new array.)
    4. If one half is exhausted, add the other half onto the new sorted array.
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
