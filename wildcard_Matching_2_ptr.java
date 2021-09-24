// Time Complexity : O(S*P)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//DP approach
class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals('*')) return true;
        
        int sLen = s.length(), pLen = p.length();
        int sMem = -1, pMem = -1;
        int sp =0, pp =0;
        
        while(sp < sLen){
            if(pp < pLen && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                pp++;
                sp++;
            } else if(pp <pLen && p.charAt(pp) == '*'){
                sMem = sp;
                pMem = pp;
                pp++;
            } else if(pMem == -1){
                return false;
            } else {
                sMem++; //for pattern matching 0, c, cd, cde,...
                sp = sMem;
                pp = pMem + 1;
            }
        }
        
        while(pp < pLen){
            if(p.charAt(pp) != '*')
                return false;
            pp++;
        }
        
        return true;
    }
}