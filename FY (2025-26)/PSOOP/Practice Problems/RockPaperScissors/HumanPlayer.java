import java.util.*;
class HumanPlayer extends Player{
    Scanner in = new Scanner(System.in);
    HumanPlayer(String name){
      super(name);
    }
    public int getGuess(){
      System.out.print("Enter move: ");
      int move = Integer.parseInt(in.nextLine());
      return move;
    }
}
