import static org.junit.Assert.*;  	
   	
 import org.junit.*;  	
   	
 public class CollinearTest {  	
     	  	
   	
     @Test  	
     public void testEmpty() {  	
         int[] a1 = {};	  	
         int[] a2 = {};  	
         int[] a3 = {};	  	
           	
         assertEquals("Arrays are empty, so count must be 0",   	
                 0, Collinear.countCollinear(a1, a2, a3));	  	
           	
     } 	
      	
     public void testEmptyFast() {  	
         int[] a1 = {};	  	
         int[] a2 = {};  	
         int[] a3 = {};	
           	
         assertEquals("Arrays are empty, so count must be 0",   	
                 0, Collinear.countCollinearFast(a1, a2, a3));  	
           	
     }  	
     	  	
     @Test	  	
     public void testOnlyA2PointsInQuadrant1() {	  	
         int[] a1 = {1, 2, 3, 4};	  	
         int[] a2 = {-1, -2, -3, -4};  	
         int[] a3 = {3, 4, 5, 6}; 	
          	
         assertEquals("Only points in a2 are in the first quadrant, so count must be 0", 	  	
                 0, Collinear.countCollinear(a1, a2, a3));	  	
           	
     }	  	
       	
     public void testOnlyA2PointsInQuadrant1Fast() {	  	
         int[] a1 = {1, 2, 3, 4};  	
         int[] a2 = {-1, -2, -3, -4};  	
         int[] a3 = {3, 4, 5, 6};	  	
           	
         assertEquals("Only points in a2 are in the first quadrant, so count must be 0",   	
                 0, Collinear.countCollinearFast(a1, a2, a3));	  	
           	
     }	  	
     	  	
     @Test  	
     public void testXnEqualsYn() {	  	
         int[] a1 = {1};	  	
         int[] a2 = {2};	  	
         int[] a3 = {3};  	
         	  	
         assertEquals("xn equals yn so count must be 1",   	
                 1, Collinear.countCollinear(a1, a2, a3));	  	
           	
     } 	
     	  	
     public void testXnEqualsYnFast() {  	
         int[] a1 = {1};  	
         int[] a2 = {2};
         int[] a3 = {3};	  	
          	
         assertEquals("xn equals yn so count must be 1",   	
                 1, Collinear.countCollinearFast(a1, a2, a3));	  	
          	
     }	  	
       	
     @Test  	
     public void testPointsFormSquare() {  	
         int[] a1 = {-5, -10, -15};	  	
         int[] a2 = {-5, -10, -15};  	
         int[] a3 = {-5, -10, -15};  	
         	  	
         assertEquals("There are 4 sides in a square and 4 lines of symmetry, three of which are horizontal, so count must be 5",   	
                 5, Collinear.countCollinear(a1, a2, a3));  	
           	
     } 	
       	
     @Test	  	
     public void testPointsFormSquareFast() {	  	
         int[] a1 = {-5, -10, -15};	  	
         int[] a2 = {-5, -10, -15};	  	
         int[] a3 = {-5, -10, -15}; 	
         	  	
         assertEquals("There are 4 sides in a square and 4 lines of symmetry, three of which are horizontal, so count must be 5", 	  	
                 5, Collinear.countCollinearFast(a1, a2, a3));  	
          	
     }	  	
 	
 }
