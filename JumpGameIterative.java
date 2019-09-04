import java.util.*;

/*
This is a dynamic programming problem solved via iteration.

The rules to the problem are as follows:
     You are playing a character in a game similar to the Chrome Dinosaur game.  You are given an input
     of scores for the jumps you character must make.  Each jump has a given score value.  After two normal jumps, your 
     character is empowered to have a super score jump, which doubles the score of your next jump.
     Your character can use the super jump at any time, but it always must charge.  Find the best possible
     score given the input and game parameters.

*/

public class JumpGameIterative {

	public static int max(int left, int right) {//you can't make me use the math
		if(left < right) {
			return right;
		}
		else {
			return left;
		}
	}

	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		ArrayList<Integer> listOfJumps = new ArrayList<Integer>();
	    HashMap<Integer, Integer> indexToMaxJumpScore = new HashMap<Integer, Integer>();	
	   // HashMap<Integer, Integer> indexToMaxJumpScore = new HashMap<Integer, Integer>();
		while(myScanner.hasNextInt()) {
      		listOfJumps.add(myScanner.nextInt());
     	 }
     	 int size = listOfJumps.size();
     	 int value = 0;
     	 int max = -1;
     	 for (int i = 0; i < size; i++) {
     	 	if(i == 0) {
     	 		value = listOfJumps.get(i);
     	 	}
     	 	else if(i == 1) {
     	 		value = listOfJumps.get(i-1) + listOfJumps.get(i);
     	 	}
     	 	else if(i == 2) {
     	 		value = listOfJumps.get(i-2) + listOfJumps.get(i-1)+ listOfJumps.get(i)*2;
     	 	}
     	 	else {
     	 		value = max(indexToMaxJumpScore.get(i-1) + listOfJumps.get(i),
     	 			indexToMaxJumpScore.get(i-3) + listOfJumps.get(i-2) + 
     	 			listOfJumps.get(i-1) + 2*listOfJumps.get(i));
     	 	}
     	 		//max = max(value, max);
     	 		indexToMaxJumpScore.put(i, value);
     	 }
     	 //int solution = optimal(listOfJumps.size()-1, listOfJumps, indexToMaxJumpScore);
     	System.out.println(indexToMaxJumpScore(listOfJumps.size()-1));
	}

}