class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
            int dp[][][] = new int [m + 1][n + 1][strs.length + 1];
           
            for(int val[][] : dp)
                    for(int value[] : val)
                            Arrays.fill(value, -1);
            
            return logic(strs, m, n, 0, dp);
            
    }
        
                public int logic(String strs[], int m, int n, int vidx, int dp[][][]){

                if(m < 0 || n < 0 || vidx >= strs.length)
                        return 0;
                        
                if(dp[m][n][vidx] != -1)
                        return dp[m][n][vidx];
                        
                        int take, notTake, one, zero, futile;
                        take = notTake = one = zero = futile = 0;
                        
                       
                        char ch[] = strs[vidx].toCharArray();
                        
                        for(char val : ch)
                                futile = val == '0' ? ++zero : ++one;
                        
                        // take
                        
                        if(m >= zero && n >= one)
                                  take = 1 + logic(strs, m - zero, n - one, vidx + 1, dp);
                        
                        // not Take 
                        
                        notTake = logic(strs, m, n, vidx + 1, dp);
                        
                        return dp[m][n][vidx] = Math.max(take, notTake);
                }
}
