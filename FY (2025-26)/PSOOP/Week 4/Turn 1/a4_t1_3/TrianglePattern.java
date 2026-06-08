
/**
 * This program prints a triangle pattern 
 *
 * @author Omkar Anil Gajare
 * @version 18/2/26
 */
public class TrianglePattern
{
    public static void main(String args[]){
        int i=0,j=0;
        for(i=5;i>=0;i--){
            for(int k=0;k<2*(5-i);k++){
                System.out.print(" ");
            }
            for(j=0;j<i;j++){
                System.out.print("$ ");
                System.out.flush();
            }
            System.out.println();
        }
    }
}