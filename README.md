## Maze-Solver
This repository contains a Java implementation of a maze solver algorithm. The algorithm takes an input maze file and uses backtracking to find the exit.

## Getting Started
To get started with this project, you will need to clone this repository to your local machine and install Java 8 or higher.

## Usage
To use this algorithm, you will need to provide an input maze file in the following format:

```
@******@@@****X
@****@@@@@@@*@*
@****@***@***@*
*@@@@@@@*****@*
*********@@@@@@
```

The above example is a maze with 5 rows and 15 columns. '*' represents empty spaces. ‘@’ represents the walls. ‘X’ represents the exit.

Once you have your input file ready, you can run the following commands to being the program and solve the maze:

```
javac MazeSolverDriver.java
java MazeSolverDriver input_file.txt num_rows num_cols
```
