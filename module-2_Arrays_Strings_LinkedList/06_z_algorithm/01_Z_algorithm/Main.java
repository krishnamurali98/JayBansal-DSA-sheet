import java.util.ArrayList;

class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        int m = pat.length();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder(pat);
        sb.append("#");
        sb.append(new StringBuilder(S));
        
        int n = sb.length();
        int[] z_array = new int[n];
        z_array[0] = 0;
        
        int L = 0, R = 0;
        for(int i=1;i<n;i++) {
            if(i > R) {
                L = R = i;
                while(R < n && sb.charAt(R - L) == sb.charAt(R))
                    R++;
                z_array[i] = R-L;
                R--;
            } else {
                if(z_array[i-L] + i <= R) 
                    z_array[i] = z_array[i-L];
                else {
                    L = i;
                    while(R < n && sb.charAt(R - L) == sb.charAt(R))
                        R++;
                    z_array[i] = R-L;
                    R--;
                }
            }
        }
        
        for(int i=0;i<n;i++) {
            if(z_array[i] == m) {
                ans.add(i-m);
            }
        }
        return ans;
    }
}