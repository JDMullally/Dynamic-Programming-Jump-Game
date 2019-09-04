import java.util.*;

/*
This is a dynamic programming problem solved via recursion.

The rules to the problem are as follows:
	You are playing a character in a game similar to the Chrome Dinosaur game.  You are given an input
	of scores for the jumps you character must make.  Each jump has a given score value.  After two normal jumps, your 
	character is empowered to have a super score jump, which doubles the score of your next jump.
	Your character can use the super jump at any time, but it always must charge.  Find the best possible
	score given the input and game parameters.

*/

public class JumpingGameRecursive {

public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		ArrayList<Integer> listOfJumps = new ArrayList<Integer>();
	    HashMap<Integer, Integer> indexToMaxJumpscore = new HashMap<Integer, Integer>(); //uses index as a key and max jump score at that index as data
	   // HashMap<Integer, Integer> indexToJump = new HashMap<Integer, Integer>();
		while(myScanner.hasNextInt()) {
      		listOfJumps.add(myScanner.nextInt());
     	 }

     	 int solution = optimal(listOfJumps.size()-1, listOfJumps, indexToMaxJumpscore);
     	 System.out.println(solution);

	}


	public static int max(int left, int right) {//gets max value
		if(left < right) {
			return right;
		}
		else {
			return left;
		}
	}

	public static int optimal(int n, ArrayList<Integer> data, 
	HashMap<Integer, Integer> hmap) {
		int value = 0;
		if(n == 0) {
			value = data.get(n);
			hmap.put(n, value);
			return value;
		}

		else if(n == 1) {
			value = data.get(n) + data.get(n-1);
			hmap.put(n, value);
			return value;
		}
		else if(n == 2) {
			value = data.get(n) * 2 + data.get(n-1) + data.get(n-2);
			hmap.put(n, value);
			return value;
		}
		else {
			if(hmap.get(n-3) != null && hmap.get(n-1) != null) {//get function for hashmaps returns null when nothing has been i
				value = max(hmap.get(n-3) + data.get(n-2) + data.get(n-1) + 2*data.get(n),
					hmap.get(n-1) + data.get(n)); //calls hashmap rather than a recursive call to
			}
			else {
				value = max(optimal(n-3, data, hmap) + data.get(n-2) + data.get(n-1) + 2*data.get(n), 
					optimal(n-1, data, hmap) + data.get(n));
				hmap.put(n, value);
			}
			return value;
		}

	}

}