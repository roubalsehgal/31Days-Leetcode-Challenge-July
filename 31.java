class Solution {
	public int climbStairs(int n) {
		int past[] = new int[n + 1];
		int ans = rec(n, past);
		return ans;
	}

	private static int rec(int n, int past[]) {
		if (n <= 1) return 1;
		if (past[n] > 0) return past[n];
		int op1 = rec(n - 1, past);
		int op2 = rec(n - 2, past);
		past[n] = op1 + op2;
		return op1 + op2;
	}
}