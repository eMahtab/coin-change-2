package net.mahtabalam.naive.recursive;

public class App {
	public static void main(String[] args) {
//		int[] v = {1, 2, 3};
//		int M = 4;
		
//		int[] v = {2, 5, 3, 6};
//		int M = 10;
//		
		int[] v = {1, 3, 5, 7};
		int M = 8;
		
		int totalWays = CoinChange.coinChange(M, v, 0);
		System.out.println("Total number of ways to make change : " + totalWays);
	}
}
