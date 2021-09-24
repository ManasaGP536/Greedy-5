// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//DP approach
class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals("*")) return true;
        
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[pLen+1][sLen+1];
        dp[0][0] = true;
        
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                //*
                if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j];
                    if(j > 0)
                        dp[i][j] = dp[i][j] || dp[i][j-1];
                }
                //char
                else if(j > 0 && (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?')) {
                    dp[i][j] = dp[i-1][j-1];
                } 
            }
        }
        
        return dp[pLen][sLen];
    }
}