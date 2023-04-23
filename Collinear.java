// -------------------------------------------------------------------------  	
 /**  	
  *  This class contains only two static methods that search for points on the  	
  *  same line in three arrays of integers. 	  	
  *  	
  *  @author    	
  *  @version 03/10/16 17:10:35  	
  */  	
 class Collinear  	
 {  
 
     static int y1 = 1; 	
     static int y2 = 2; 	
     static int y3 = 3; 	
       	
    // ----------------------------------------------------------  	
     /** 	
      * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.  	
      * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)	  	
      * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.  	
      * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain. 	
      * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.  	
      * @return the number of points which are collinear and do not lie on a horizontal line. 	
      *  	
      * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.	  	
      * A non-horizontal line will have to cross all three of these lines. Thus 	
      * we are looking for 3 points, each in a1, a2, a3 which lie on the same  	
      * line.  	
      *	  	
      * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if	  	
      * 	  	
      * x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0 	  	
      *  	
      * In our case y1=1, y2=2, y3=3.  	
      *  	
      * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)  	
      *  	
      * ----------------------------------------------------------  	
      *	  	
      * Experimental Performance:
      * -------------------------  	
      *  Write the running time of the algorithm when run with the following input sizes  	
      *   	
      *  Input Size N      Running Time (sec)	  	
      *  ------------------------------------  	
      *  1000              0.52  	
      *  2000              3.658  	
      *  4000              28.66  	
      *	  	
      *  Assuming that the running time of your algorithm is of the form aN^b,  	
      *  estimate 'b' and 'a' by fitting a line to the experimental points:  	
      *  	
      *  b = 2.892  	
      *  a = 1.08*10^-9	  	
      *  	
      *  What running time do you predict using your results for input size 5000?  	
      *  What is the actual running time you get with such an input?  	
      *  What is the error in percentage? 	
      *  	
      *  Error = ( (Actual time) - (Predicted time) ) * 100 / (Predicted time)  	
      *  	
      *  Input Size N      Predicted Running Time (sec)        Actual Running Time (sec)       Error (%)  	
      *  ------------------------------------------------------------------------------------------------ 	
      *  5000              53.8078                                53.507                           -0.5590  	
      *   	
      *  Order of Growth  	
      *  -------------------------  	
      *  	
      *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.  	
      *  You should adequately explain your answer. Answers without adequate explanation will not be counted.  	
      *  	
      *  Order of growth: O(N^3)  	
      *	  	
      *  Explanation: The frequency of array accesses in the triple loop makes it so a1.length * a2.length * a3.length, i.e. N*N*N = N^3.
      *  I calculated the frequency of array accesses because this operation is the one that occurs the most times. 	
      *  The upper bound is cubic, i.e. the running time in worst-case input will not be any more than N^3.  	
      *    	
      */ 	
     static int countCollinear(int[] a1, int[] a2, int[] a3) 	
     { 	
         int count = 0;  	
         for (int i = 0; i<a1.length; i++)
             for(int j = 0; j<a2.length; j++)  	
                 for(int k = 0; k<a3.length; k++)	  	
                     if(((a1[i]*(y2 - y3)) + (a2[j]*(y3-y1)) + (a3[k]*(y1-y2))) == 0)	
                         count++; 	
       return count;  	
     }  	
   	
     // ----------------------------------------------------------	  	
     /**  	
      * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.	  	
      * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)	  	
      * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.  	
      * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.  	
      * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain. 	
      * @return the number of points which are collinear and do not lie on a horizontal line.	
      * 	
      * In this implementation you should make non-trivial use of InsertionSort and Binary Search.	  	
      * The performance of this method should be much better than that of the above method.  	
      *  	
      * Experimental Performance:  	
      * -------------------------	  	
      *  Measure the running time of the algorithm when run with the following input sizes  	
      *  	  	
      *  Input Size N      Running Time (sec)	  	
      *  ------------------------------------  	
      *  1000              0.134  	
      *  2000              0.225	  	
      *  4000              0.965  	
      *  5000              1.496	  	
      *	  	
      *  	
      *  Compare Implementations:	  	
      *  ------------------------  	
      *  Show the speedup achieved by this method, using the times you got from your experiments.	  	
      *  	
      *  Input Size N      Speedup = (time of countCollinear)/(time of countCollinearFast)	  	
      *  ---------------------------------------------------------------------------------	  	
      *  1000              3.881	  	
      *  2000              16.258  	
      *  4000              29.699  	
      *  5000              35.767	  	
      *  	
      *  	
      *  Order of Growth	  	
      *  -------------------------  	
      *	  	
      *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.	  	
      *  You should adequately explain your answer. Answers without adequate explanation will not be counted.	  	
      *	  	
      *  Order of Growth: O(N^2lgN)	  	
      *	  	
      *  Explanation: The frequency of array accesses in the double loop makes it so a1.length * a2.length, i.e. N*N = N^2,  	
      *  while the binary search for the third element results in the logarithmic order of growth of logN.  	
      *  The upper bound is N^2lgN, i.e. the running time in worst-case input will not be any more than N^2lgN.	  	
      *	  	
      */	  	
     static int countCollinearFast(int[] a1, int[] a2, int[] a3)	  	
     {  	
         int count = 0;	  	
         	  	
         boolean sorted = false;  	
         for (int i = 0; i<a3.length-1 && !sorted; i++)	  	
         {	  	
             if(a3[i]>a3[i+1])  	
             {  	
                 Collinear.sort(a3);	  	
                 sorted = true;	  	
             }  	
         }  	
                 	  	
         for (int i = 0; i<a1.length; i++)  	
         {  	
             for(int j = 0; j<a2.length; j++)	  	
             {	  	
                   	
                 int x = -(a1[i]*(y2 - y3) + a2[j]*(y3-y1)) / (y1-y2);	  	
                 if(Collinear.binarySearch(a3, x) == true)	  	
                     count++;	  	
             }	  	
         }	  	
       return count;	  	
     }  	
 	  	
     // ----------------------------------------------------------	  	
     /**	  	
      * Sorts an array of integers according to InsertionSort.	  	
      * This method is static, thus it can be called as Collinear.sort(a)	  	
      * @param a: An UNSORTED array of integers.	
      * @return after the method returns, the array must be in ascending sorted order.	  	
      *	  	
      * ----------------------------------------------------------	  	
      *	  	
      * Approximate Mathematical Performance:  	
      * -------------------------------------	  	
      *  Using an appropriate cost model, give the performance of your algorithm.	  	
      *  Explain your answer.  	
      *	  	
      *  Performance: O(N^2)	  	
      * 	
      *  Explanation: The frequency of array accesses in the double loop makes it so N*(N-1) =~N^2.	  	
      *  The upper bound is N^2, i.e. the running time in worst-case input will not be any more than N^2.	  	
      *  This worst case would be present if the elements in the array were organised in the completely reversed order.	  	
      *	  	
      */	  	
     static void sort(int[] a)	  	
     {	  	
         int temp = 0;	  	
         int j = 0;	  	
         for(int i = 1; i<a.length; i++)	  	
         {  	
             temp = a[i];	  	
             j = i-1;	  	
             while(j>=0 && a[j]>temp)	  	
             {  	
                 a[j+1] = a[j];	  	
                 j--;  	
             }	  	
             a[j+1] = temp;	  	
         }	  	
     }	  	
   	
     // ----------------------------------------------------------	  	
     /**  	
      * Searches for an integer inside an array of integers.	  	
      * This method is static, thus it can be called as Collinear.binarySearch(a,x)	  	
      * @param a: A array of integers SORTED in ascending order.	  	
      * @param x: An integer.	  	
      * @return true if 'x' is contained in 'a'; false otherwise.  	
      *	  	
      * ----------------------------------------------------------	  	
      *  	
      * Approximate Mathematical Performance:	  	
      * -------------------------------------  	
      *  Using an appropriate cost model, give the performance of your algorithm.  	
      *  Explain your answer.	  	
      *	  	
      *  Performance: O(lgN+1)  	
      *	  	
      *  Explanation: The the worst case is that the integer x is not an element of the integer array a, 	  	
      *  which results in recurring continuously until there is only one element left.	  	
      *  The upper bound is lgN+1, i.e. the running time in worst-case input will not be any more than lgN+1.	  	
      *	  	
      *	  	
      */	  	
     static boolean binarySearch(int[] a, int x)	  	
     {  	
         int lo = 0;	  	
         int hi = a.length -1;	  	
         int mid = 0;	  	
         	  	
         while(lo<=hi)	  	
         {	  	
             mid = (lo+hi)/2;  	
             if(a[mid]<x)  	
                 lo = mid+1;	  	
             else if(a[mid]>x)	  	
                 hi = mid-1;	  	
             else	  	
                 return true;  	
         }	  	
       return false;	  	
     }	  	
       	
     /* public static void main(String[] args) 	  	
     {	  	
         In in1000 = new In("r01000-1.txt");	  	
         int [] a1 = in1000.readAllInts();	  	
         In in1000_2 = new In("r01000-2.txt");	  	
         int [] a2 = in1000_2.readAllInts();	  	
         In in1000_3 = new In("r01000-3.txt");	  	
         int [] a3 = in1000_3.readAllInts();	  	
         	  	
         Stopwatch stopwatch1000 = new Stopwatch();	  	
         StdOut.println(Collinear.countCollinear(a1, a2, a3));	  	
         double time1000 = stopwatch1000.elapsedTime();	  	
         StdOut.println("elapsed time for N = 1000 " + time1000);	  	
         //************************************************************  	
         In in2000 = new In("r02000-1.txt");	  	
         int [] a1_2 = in2000.readAllInts();	  	
         In in2000_2 = new In("r02000-2.txt");	  	
         int [] a2_2 = in2000_2.readAllInts();	  	
         In in2000_3 = new In("r02000-3.txt");	  	
         int [] a3_2 = in2000_3.readAllInts();	  	
           	
         Stopwatch stopwatch2000 = new Stopwatch();	  	
         StdOut.println(Collinear.countCollinear(a1_2, a2_2, a3_2));	  	
         double time2000 = stopwatch2000.elapsedTime();	  	
         StdOut.println("elapsed time for N = 2000 " + time2000);	  	
         //************************************************************	  	
         In in4000 = new In("r04000-1.txt");	  	
         int [] a1_4 = in4000.readAllInts();  	
         In in4000_2 = new In("r04000-2.txt");  	
         int [] a2_4 = in4000_2.readAllInts();	  	
         In in4000_3 = new In("r04000-3.txt");	  	
         int [] a3_4 = in4000_3.readAllInts();	  	
     	  	
         Stopwatch stopwatch4000 = new Stopwatch();	  	
         StdOut.println(Collinear.countCollinear(a1_4, a2_4, a3_4));	  	
         double time4000 = stopwatch4000.elapsedTime();	  	
         StdOut.println("elapsed time for N = 4000 " + time4000);  	
         //************************************************************	  	
         In in5000 = new In("r05000-1.txt");	  	
         int [] a1_5 = in5000.readAllInts();	  	
         In in5000_2 = new In("r05000-2.txt");	  	
         int [] a2_5 = in5000_2.readAllInts();	  	
         In in5000_3 = new In("r05000-3.txt");	  	
         int [] a3_5 = in5000_3.readAllInts();	  	
         	  	
         Stopwatch stopwatch5000 = new Stopwatch();	  	
         StdOut.println(Collinear.countCollinear(a1_5, a2_5, a3_5));	  	
         double time5000 = stopwatch5000.elapsedTime();	  	
         StdOut.println("elapsed time for N = 5000 " + time5000);	  	
         	  	
         	  	
         In stdIn1000 = new In("r01000-1.txt");	  	
         int [] b1 = stdIn1000.readAllInts();	  	
         In stdIn1000_2 = new In("r01000-2.txt");	  	
         int [] b2 = stdIn1000_2.readAllInts();	  	
         In stdIn1000_3 = new In("r01000-3.txt");  	
         int [] b3 = stdIn1000_3.readAllInts();	  	
         	  	
         Stopwatch watch1000 = new Stopwatch();	  	
         StdOut.println(Collinear.countCollinearFast(b1, b2, b3));	  	
         double t1000 = watch1000.elapsedTime();	  	
         StdOut.println("elapsed time for N = 1000 " + t1000);  	
         //************************************************************	  	
         In stdIn2000 = new In("r02000-1.txt");	  	
         int [] b1_2 = stdIn2000.readAllInts();	  	
         In stdIn2000_2 = new In("r02000-2.txt");	  	
         int [] b2_2 = stdIn2000_2.readAllInts();	  	
         In stdIn2000_3 = new In("r02000-3.txt");	  	
         int [] b3_2 = stdIn2000_3.readAllInts();	  	
          	
         Stopwatch watch2000 = new Stopwatch();  	
         StdOut.println(Collinear.countCollinearFast(b1_2, b2_2,b3_2));  	
         double t2000 = watch2000.elapsedTime();	  	
         StdOut.println("elapsed time for N = 2000 " + t2000);	  	
         //************************************************************  	
         In stdIn4000 = new In("r04000-1.txt");	  	
         int [] b1_4 = stdIn4000.readAllInts();  	
         In stdIn4000_2 = new In("r04000-2.txt");	  	
         int [] b2_4 = stdIn4000_2.readAllInts();	  	
         In stdIn4000_3 = new In("r04000-3.txt");	  	
         int [] b3_4 = stdIn4000_3.readAllInts();	  	
     	  	
         Stopwatch watch4000 = new Stopwatch();  	
         StdOut.println(Collinear.countCollinearFast(b1_4, b2_4, b3_4));	  	
         double t4000 = watch4000.elapsedTime();	  	
         StdOut.println("elapsed time for N = 4000 " + t4000);	  	
         //************************************************************  	
         In stdIn5000 = new In("r05000-1.txt");	  	
         int [] b1_5 = stdIn5000.readAllInts();  	
         In stdIn5000_2 = new In("r05000-2.txt");	  	
         int [] b2_5 = stdIn5000_2.readAllInts();	  	
         In stdIn5000_3 = new In("r05000-3.txt");	  	
         int [] b3_5 = stdIn5000_3.readAllInts();	  	
         	  	
         Stopwatch watch5000 = new Stopwatch();	  	
         StdOut.println(Collinear.countCollinearFast(b1_5, b2_5, b3_5));	  	
         double t5000 = watch5000.elapsedTime();
         StdOut.println("elapsed time for N = 5000 " + t5000);	  	
         	  	
     }*/  	
   	
 }
