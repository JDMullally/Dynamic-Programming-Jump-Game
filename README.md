# Dynamic-Programming-Jump-Game

This is a dynamic programming problem solved via both iteration and recursion

This program is simple, but can be applied in other ways with different data for different problems.  It mainly illustrates the two different approaches for dynamic programming in this case(with a loop or with recursion).

Both of these programs run in linear time (although the iterative one is quicker) because they use memoization.  Without proper book-keeping of previous results, the program would be much slower.  That's the real purpose of the example

The rules to the problem are as follows:
     You are playing a character in a game similar to the Chrome Dinosaur game.  You are given an input
     of scores for the jumps you character must make.  Each jump has a given score value.  After two normal jumps, your 
     character is empowered to have a super score jump, which doubles the score of your next jump.
     Your character can use the super jump at any time, but it always must charge.  Find the best possible
     score given the input and game parameters.

Running this Program
1. Download the .java and .txt files
2. Go to the folder holding the files in terminal
3. Run javac on either java file to compile them
4. Run java filename < 455.txt to get the answer 455


This program will give the optimal value for any text file of integers.
