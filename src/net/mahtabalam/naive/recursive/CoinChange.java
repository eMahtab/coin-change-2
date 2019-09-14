package net.mahtabalam.naive.recursive;

public class CoinChange {
	
    public static int coinChange( int M, int[] v, int index) 
    { 
        // If amount M is 0 then there is 1 solution (do not include any coin) 
        if (M == 0) 
            return 1; 
          
        // If amount M is less than 0 then no solution exists 
        if (M < 0) 
            return 0; 
      
        // If we considered all the coins in the array v and no more coins left 
        if (index == v.length) 
            return 0; 
      
        return coinChange(M-v[index], v, index) + coinChange(M, v, index+1); 
    } 

}
