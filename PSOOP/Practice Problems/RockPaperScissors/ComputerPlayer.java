import java.util.*;
class ComputerPlayer extends Player{
    ComputerPlayer(String name){
      super(name);
    }
    public int getGuess(){
      Random r = new Random();
      return r.nextInt(3);
    }
}
