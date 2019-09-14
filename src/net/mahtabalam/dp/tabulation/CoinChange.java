package net.mahtabalam.dp.tabulation;

public class CoinChange {

	public static int coinChange(int[] v, int M) {

		int[][] dpTable = new int[v.length + 1][M + 1];

		for (int i = 0; i <= v.length; i++) {
			dpTable[i][0] = 1;
		}
		for (int j = 1; j <= M; j++) {
			dpTable[0][j] = 0;
		}

		for (int i = 1; i <= v.length; i++) {
			for (int j = 1; j <= M; j++) {
				if (v[i - 1] > j) {
					dpTable[i][j] = dpTable[i - 1][j];
				} else {
					dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - v[i - 1]];
				}
			}
		}
		return dpTable[v.length][M];
	}
}
