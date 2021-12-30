# Coin Change
## https://leetcode.com/problems/coin-change-2

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 
```
Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

Input: amount = 10, coins = [10]
Output: 1
``` 

## Constraints:
```
1. 1 <= coins.length <= 300
2. 1 <= coins[i] <= 5000
3. All the values of coins are unique.
4. 0 <= amount <= 5000
```


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

