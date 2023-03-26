/* Nawfal Cherkaoui Elmalki
 * Dr. Steinberg
 * COP3503 Spring 2023
 * Programming Assignment 2
 */

// Pre-processor directives
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.awt.Point;

// Magic Maze class
public class MagicMaze
{
        // Instance and class variables
        private static final int [] rowMoves = {-1, 0, 1, 0};
        private static final int [] colMoves = {0, -1, 0, 1};
        private Point [][] teleportPads;
        private char [][] maze;
        private String mazeNum;
        private int rows;
        private int cols;

        // Constructor
        public MagicMaze(String file, int rows, int cols)
        {
                this.mazeNum = file;
                this.rows = rows;
                this.cols = cols;
                this.maze = new char[rows][cols];
                this.teleportPads = new Point[10][2];
                mazeReader(mazeNum);
        }

        // Wrapper method
        // returns boolean that represents whether the maze was solved
        public boolean solveMagicMaze()
        {
                return solveMagicMazeR(rows - 1, 0);
        }

        // Backtracking method
        // Returns a Boolean value. If the value is true, then the maze was solved 
        // successfully, otherwise the maze was not solved successfully.
        private boolean solveMagicMazeR(int row, int col)
        {
                // For testing purposes
                try
                {
                        Thread.sleep(50);
                }
                catch (InterruptedException e)
                {
                        e.printStackTrace();
                }

                // Gets ascii value of current maze character
                char prevChar = maze[row][col];
                int ascii = (int) prevChar - '0';
                
                // Base case, if we beat the maze return true
                if (prevChar == 'X')
                {
                        return true;
                }

                // Adds an obstacle so we don't revisit deadends
                maze[row][col] = '.';

                // If we are on a teleport pad, teleport
                if (ascii >= 0 && ascii < 10)
                {
                        // Checks teleportPads array to find the other teleport pad
                        for(int i = 0; i < 2; i++)
                        {
                                Point currentPad = teleportPads[ascii][i];
                                int newRow = (int)currentPad.getX();
                                int newCol = (int)currentPad.getY();

                                if ((newRow != row || newCol != col) && maze[newRow][newCol] != '@')
                                {
                                        if (solveMagicMazeR(newRow, newCol))
                                        {
                                                return true;
                                        }
                                }
                        }
              }

                // For testing purposes
                for (int i = 0; i < rows; i++)
                {
                        for (int j = 0; j < cols; j++)
                        {
                                System.out.print(maze[i][j]);
                        }
                        System.out.println();
                }
                System.out.println();

                // Checks all possible moves
                for (int i = 0; i < rowMoves.length; i++)
                {
                        int newRow = row + rowMoves[i];
                        int newCol = col + colMoves[i];

                        // If this is a partial solution, return true
                        if(validPos(newRow, newCol))
                        {
                                if (solveMagicMazeR(newRow, newCol))
                                {
                                        return true;
                                }
                        }
                }
                
                // Backtracking statements
                maze[row][col] = prevChar;
                return false;
        }

        // Reads the file into the 2D maze array
        private void mazeReader(String file)
        {
                Scanner sc = null;
                int row;
                int col;
                
                try 
                {
                        sc = new Scanner(new File (file));
                        sc.useDelimiter("");
                }
                catch (FileNotFoundException e) 
                {
                        System.out.println("Specify a file please!");
                }
                
                // For each line
                for (row = 0; row < rows; row++)
                {
                        String line = sc.nextLine();

                        // For each char
                        for (col = 0; col < cols; col++)
                        {
                                char c = line.charAt(col);
                                int ascii = (int) c - '0';
                                
                                // If teleport pad, add to teleportPads array
                                if (ascii >= 0 && ascii < 10)
                                {
                                        for(int i = 0; i < 2; i++)
                                        {
                                                if (teleportPads[ascii][i] == null)
                                                {
                                                        teleportPads[ascii][i] = new Point(row, col);
                                                        break;
                                                }
                                        }
                                }
                                maze[row][col] = line.charAt(col);
                        }
                }
        }

        // Checks if the current position in the maze is valid
        private boolean validPos(int row, int col)
        {
                return (row >= 0 && row < maze.length) && (col >= 0 && col < maze[0].length) && (maze[row][col] != '@') && (maze[row][col] != '.');
        }

        // For testing purposes
        // public static void main(String [] args) throws Exception
        // {
        //         MagicMaze maze = new MagicMaze(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        //         System.out.println(maze.solveMagicMaze());
        // }
}