class Solution {
    private static int[] calculate_lps(String p) {
        int m = p.length();
        
        int[] lps = new int[m];
        Arrays.fill(lps, 0);
        
        int i=0, j=1;
        while(j < m) {
            if(p.charAt(i) == p.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if(i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i-1];
                }
            }
        }
        return lps;
    }
     

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] lps = calculate_lps(pat);
       
        
        int n = txt.length();
        int m = pat.length();
        
        int i=0, j=0;
        while(i < n) {
            if(txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if(j == m) {
                    ans.add(i-m);
                    j = lps[j-1];
                }
            } else {
                if(j == 0)
                    i++;
                else
                    j = lps[j-1];
            }
        }
        return ans;
        
    }
}