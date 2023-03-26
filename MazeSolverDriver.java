import java.io.File;
import java.util.Scanner;

public class MagicMazeDriver 
{   
    public static void main(String args[]) throws Exception
    {
        MazeSolver maze;
           
        while(true)
        {
            maze = new MazeSolver(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            maze.solveMagicMaze();
        }
    }
}
