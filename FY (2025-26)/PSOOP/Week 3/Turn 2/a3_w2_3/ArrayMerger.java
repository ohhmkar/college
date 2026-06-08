import java.util.*;
import java.io.*;
/**
 * This program takes input of two sorted arrays and prints a merged array 
 *
 * @author Omkar Gajare
 * @version 13/2/26
 */
public class ArrayMerger
{
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);

        int lenA,lenB;//Initializing variables for lengths of array A and B
        //Taking input of array A
        System.out.println("Enter size of array A: ");
        lenA = Integer.parseInt(in.readLine());
        System.out.println("Enter the elements of A: ");
        int[] A = new int[lenA];
        for(int i=0;i<lenA;i++){
            A[i] = Integer.parseInt(in.readLine());
        }
        //Taking input of array B
        System.out.println("Enter size of array B: ");
        lenB = Integer.parseInt(in.readLine());
        int[] B = new int[lenB];
        System.out.println("Enter the elements of B: ");
        for(int i=0;i<lenB;i++){
            B[i] = Integer.parseInt(in.readLine());
        }

        int l=0,r=0,i=0;//Initializing three iterators; l for iterating through A, r for iterating through B and i for iterating through C 
        int[] C = new int[lenA+lenB];//initialzing array C of size A+B
        //implementing a two iterator approach
        do{
            if(A[l]<B[r]){ 
                //If current element pointed to by A[l] is smaller it is added to C
                C[i] = A[l];
                l++;
            }
            else{
                //Else current element pointed to by B[r] is added to C
                C[i] = B[r];
                r++;
            }
            i++;
        }while(l<lenA && r<lenB && i<lenA+lenB);
        //above loop breaks when either of the arrays is exhausted
        
        //this loop adds (if any) remaining elements of A to C
        for(;l<lenA;l++){
            C[i] = A[l];
            i++;
        }
        //this loop adds (if any) remaining elements of B to C
        for(;r<lenB;r++){
            C[i] = B[r];
            i++;
        }
        //Printing the array C
        System.out.println("Merged Array C:");
        for(i=0;i<lenA+lenB;i++){
            System.out.println(C[i]+" ");
        }
    }
}