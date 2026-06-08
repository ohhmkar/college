import java.util.*;
class MyGame implements Game{
    Scanner in = new Scanner(System.in);
    String player1, player2;
    String p1_type, p2_type;
    
    MyGame(String p1_type,String p2_type, String player1, String player2){
      this.p1_type = p1_type;
      this.p2_type = p2_type;
      this.player1 = player1;
      this.player2 = player2;
    }
    
    public void play(){
        Player p1 = new ComputerPlayer("Default");
        Player p2 = new ComputerPlayer("Default");
        if(p1_type == "Human" && p2_type == "Human"){
          p1 = new HumanPlayer(player1);
          p2 = new HumanPlayer(player2);
        }
        if(p1_type == "Human" && p2_type == "Computer"){
          p1 = new HumanPlayer(player1);
          p2 = new ComputerPlayer("Computer");
        }
        if(p1_type == "Computer" && p2_type == "Computer"){
          p1 = new ComputerPlayer(player1);
          p2 = new ComputerPlayer(player2); 
        }
        
        String game_type = (p2_type == "Human") ? "HVH" : ((p1_type == "Computer") ? "CVC" : "HVC");
        int p1_move = 3, p2_move = 3;
        switch(game_type){
            case "HVH":
                System.out.println("\n"+player1+" ,Enter your choice: (0 = Rock, 1 = Paper, 2 = Scissors)");
                p1_move = p1.getGuess();
                System.out.println("\n"+player2+" ,Enter your choice: (0 = Rock, 1 = Paper, 2 = Scissors)");
                p2_move = p2.getGuess();
                break;
            case "HVC":
                System.out.println(player1+" ,Enter your choice: (0 = Rock, 1 = Paper, 2 = Scissors)");
                p1_move = p1.getGuess();
                p2_move = p2.getGuess();
                System.out.println("Computer picked: "+((p2_move == 0) ? "Rock" : ((p2_move == 1) ? "Paper" : "Scissors")));
                break;
            case "CVC":
                p1_move = p1.getGuess();
                p2_move = p2.getGuess();
                System.out.println(player1+" picked: "+((p1_move == 0) ? "Rock" : ((p1_move == 1) ? "Paper" : "Scissors")));
                System.out.println(player2+" picked: "+((p2_move == 0) ? "Rock" : ((p2_move == 1) ? "Paper" : "Scissors")));
                break;
            default:
                System.out.println("huh");
        }
        String winner = findWinner(p1_move,p2_move);
        switch(winner){
            case "Tie":
                System.out.println("\nIt's a tie!");
                break;
            case "Player 1":
                System.out.println("\n"+player1 + " Wins!");
                break;
            case "Player 2":
                System.out.println("\n"+player2 + " Wins!");
                break;
            default:
                System.out.println("How did we get here?");
        }
    }
    
    public String findWinner(int p1_move, int p2_move){
        if(p1_move == p2_move){
            return "Tie";
        }
        else{
            if((p1_move == 0 && p2_move == 1)||
               (p1_move == 1 && p2_move == 2)||
               (p1_move == 2 && p2_move == 0)){
                return "Player 2";
            }
            else{
                return "Player 1";
            }
        }
    }
}
