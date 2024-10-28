/*
 This problem is known as the Gas Station problem and is often encountered in algorithm challenges. 
The goal is to determine if you can complete the circuit starting from a specific gas station, and if so, 
return the starting gas station's index. If it's not possible to complete the circuit, return -1.

Problem Explanation:
You have n gas stations arranged in a circle.
gas[i] represents the amount of gas at station i.
cost[i] represents the cost of gas required to travel from station i to station i + 1.
The task is to find the starting gas station index from which you can travel around the circle and return to the same station 
without running out of gas. 
 */
package a.array.cond;


public class GasStation {
	public static void main(String[] args) {
		
	//	gas = [2,3,4], cost = [3,4,3]
		int[] gas = new int[] {1, 2, 3, 4, 5}; 
		int[] cost = new int[] {3, 4, 5, 1, 1};	
		
		int index= canCompleteCircuit(gas, cost);
		
		if(index!= -1) {
			System.out.println("Can go ");
			return;
		}
		System.out.println("Not to go ");
	}

	static public int canCompleteCircuit(int[] gas, int[] cost) {
		int total_gas = 0;
		int total_cost = 0;
		int tank = 0;
		int start = 0;

		for (int i = 0; i < gas.length; i++) {
			total_gas  = total_gas +gas[i];
			total_cost = total_cost +cost[i];
			tank = tank + gas[i] - cost[i];
			// If tank is negative, reset the start index to i + 1
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		// Check if a valid start index is found
		return total_gas >= total_cost ? start : -1;
	}
}
