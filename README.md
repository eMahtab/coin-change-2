# Coin Change
## https://leetcode.com/problems/coin-change-2





# Implementation :
```java
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dpTable = new int[coins.length + 1][amount + 1];

	for (int i = 0; i <= coins.length; i++) {
	    dpTable[i][0] = 1; // 1 way to make change for 0
	}
	for (int j = 1; j <= amount; j++) {
            // no way (0) to make change for amount greater than zero with 0 value coin
	    dpTable[0][j] = 0; 
	}

	for (int i = 1; i <= coins.length; i++) {
	   for (int j = 1; j <= amount; j++) {
		if (coins[i - 1] > j) {
		    dpTable[i][j] = dpTable[i - 1][j];
		} else {
		    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - coins[i - 1]];
		}
	   }
	}
	return dpTable[coins.length][amount];
    }
}
```

# References :
https://www.youtube.com/watch?v=nCwfxw3GH-g

