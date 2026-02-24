import java.util.*;
import java.io.*;
/**
 * This program counts the votes in an election and returns the results
 *
 * @author Omkar Gajare
 * @version 13/2/26
 */
public class VotesCalculator
{
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        int[] votes = {0,0,0,0,0,0};//Array of 6 elements, 1-5 stores votes of respective 1-5 and 0 indexed stores spoilt ballots
        int curr_vote = 1;//Initialzing curr_vote as JAVA doesnt let non initialized elements be used as conditions
        System.out.println("Enter votes(1-5). Enter 0 to stop.");
        while(curr_vote!=0){
            curr_vote = Integer.parseInt(in.readLine());//Entry of current vote
            if(curr_vote>0 && curr_vote<6){
                votes[curr_vote]++;//Incrementing array position of current vote
            }
            else if(curr_vote == 0){
                continue;//If 0 is entered program should break
            }
            else{
                votes[0]++;//Spoilt Ballot Tally
            }
        }
        //Printing results of Candidates 1-5
        System.out.println("Results");
        for(int i=1;i<=5;i++){
            System.out.println("Candidate "+i+": "+votes[i]);
        }
        System.out.println("Spoilt Ballots: "+votes[0]);//Printing the spoilt ballots stored in 0 index
    }
}