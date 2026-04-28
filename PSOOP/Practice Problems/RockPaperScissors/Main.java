import java.util.*;
/**
 * Main Game Engine
 *
 * @author Omkar Anil Gajare
 *
*/
public class Main {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.println("\nROCK PAPER SCISSORS");
      System.out.println("1. Human vs Human");
      System.out.println("2. Human vs Computer");
      System.out.println("3. Computer vs Computer");
      System.out.println("4. Exit");
      MyGame game = new MyGame("", "", "", "");
      System.out.println("Enter choice: ");
      int choice = Integer.parseInt(in.nextLine());
      if (choice == 1) {
        System.out.println("Player 1, Enter your name");
        String player1 = in.nextLine();
        System.out.println("Player 2, Enter your name");
        String player2 = in.nextLine();
        game = new MyGame("Human", "Human", player1, player2);
      } else if (choice == 2) {
        System.out.println("Human, Enter your name");
        String player1 = in.nextLine();
        game = new MyGame("Human", "Computer", player1, "Computer");
      } else if (choice == 3) {
        game = new MyGame("Computer", "Computer", "Computer 1", "Computer 2");
      } else {
        System.out.println("\n\nThank you for playing!");
        System.exit(0);
      }
      game.play();
    }
  }
}
