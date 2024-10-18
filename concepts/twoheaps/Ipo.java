package concepts.twoheaps;

import java.util.PriorityQueue;

/*
    A busy investor with an initial capital, c, needs an automated investment program. They can select k distinct projects from a 
    list of n projects with corresponding capitals requirements and expected profits. For a given project ii, its capital requirement 
    is capitals[i]capitals[i] , and the profit it yields is profits[i]profits[i].

    The goal is to maximize their cumulative capital by selecting a maximum of k distinct projects to invest in, subject to the constraint 
    that the investor’s current capital must be greater than or equal to the capital requirement of all selected projects.

    When a selected project from the identified ones is finished, the pure profit from the project, along with the starting capital 
    of that project is returned to the investor. 
    This amount will be added to the total capital held by the investor. Now, the investor can invest in more projects with the new 
    total capital. It is important to note that each project can only be invested once.

    As a basic risk-mitigation measure, the investor wants to limit the number of projects they invest in. For example, if k is 22, 
    the program should identify the two projects that maximize the investor’s profits while ensuring that the investor’s capital is 
    sufficient to invest in the projects.

    Overall, the program should help the investor to make informed investment decisions by picking a list of a maximum of k distinct 
    projects to maximize the final profit while mitigating the risk.

    Constraints:
        1) 1 ≤ k ≤ 10^3
        2) 0 ≤ c ≤ 10^9
        3) 1 ≤ n ≤ 10^3
        4) k ≤ n
        5) n == profits.length
        6) n == capitals.length
        7) 0 ≤ profits[i] ≤ 10^4
        8) 0 ≤ capitals[i] ≤ 10^9
 */
public class Ipo {
    /*
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {

        int n = capitals.length;
		int currentCapital = c;
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; ++i) {
            capitalMinHeap.offer(new int[] {capitals[i], i});
        }

        PriorityQueue<int[]> profitsMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
		int i = 0;
        while (i < k) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
				int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(new int[]{profits[j[1]]});
            }

            if (profitsMaxHeap.isEmpty()) {
                break;
            }

			int x = profitsMaxHeap.poll()[0];
            currentCapital += x;
			i++;
        }

        return currentCapital;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] capitals = { 1, 3, 4, 5, 6 };
        int[] profits = { 1, 2, 3, 4, 5 };
        System.out.println(maximumCapital(2, 3, capitals, profits));
    }
}
