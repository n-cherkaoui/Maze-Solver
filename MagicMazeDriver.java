/** Dr. Andrew Steinberg
 *  COP3503 Computer Science 2
 *  Programming Assignment 2 Driver
 *  Spring 2023
 */
 
import java.io.File;
import java.util.Scanner;

public class MagicMazeDriver 
{   
    public static void main(String args[]) throws Exception
    {
        MagicMaze maze;
           
        while(true)
        {
            maze = new MagicMaze(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            maze.solveMagicMaze();
        }
    }
}
