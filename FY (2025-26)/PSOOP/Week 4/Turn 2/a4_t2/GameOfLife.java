import java.io.*;
/**
 * 
 * This program simulates the Game of Life where:
 * '@' - Living Organism
 * '#' - Dead Organism
 * 
 * Rules are that if surrounded by less than or equal to 2 and more than or equal to 4 neighbours, cell dies else if cell has exactly 3 then it will become alive.
 * If 2 or 3 alive it stays alive next gen.
 * 
 * @author Omkar Anil Gajare
 * @version 21/2/26
 */
public class GameOfLife{
    public static void main(String args[]) throws IOException{
        DataInputStream in = new DataInputStream(System.in);
        // Read rows and columns
        String firstLine = in.readLine();
        String[] rc = firstLine.split(" ");
        int R = Integer.parseInt(rc[0]);
        int C = Integer.parseInt(rc[1]);
        // Read initial grid
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = in.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // Read the number of generations to simulate 
        int noOfGenerations = Integer.parseInt(in.readLine());
        int currGen = 0;

        // Simulate each generation until we reach the specified number of generations
        while (currGen < noOfGenerations) {

            // Create a fresh grid for the next generation
            char[][] nextGen = new char[R][C];
            for(int i = 0 ;i<R;i++) for(int j=0;j<C;j++) nextGen[i][j] = grid[i][j];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                    // Count the number of live neighbours in all directions 
                    int liveNeighbours = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            // Skip the cell itself
                            if (x == 0 && y == 0) 
                                continue;

                            // Check bounds, then check if neighbour is alive
                            if (i + x >= 0 && i + x < R && j + y >= 0 && j + y < C) {
                                if (grid[i + x][j + y] == '@') {
                                    liveNeighbours++;
                                }
                            }
                        }
                    }

                    // Apply the rules of the Game of Life
                    //Cell dies from underpopulation (< 2) or overpopulation (>= 4)
                    if (liveNeighbours < 2 || liveNeighbours >= 4) {
                        nextGen[i][j] = '#';
                    }

                    //Dead cell with exactly 3 neighbours becomes alive
                    if (liveNeighbours == 3 && grid[i][j] == '#') {
                        nextGen[i][j] = '@';
                    }
                    //Live cell with 2 or 3 neighbours survives
                    else if ((liveNeighbours == 2 || liveNeighbours == 3) && grid[i][j] == '@') {
                        nextGen[i][j] = '@';
                    }
                }
            } 

            // Print the current generation
            System.out.println("Generation " + (currGen + 1) + ":");
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(nextGen[i][j]);
                }
                System.out.println();
            }

            // Advance to the next generation
            grid = nextGen;
            currGen++;
        }
    }
}
