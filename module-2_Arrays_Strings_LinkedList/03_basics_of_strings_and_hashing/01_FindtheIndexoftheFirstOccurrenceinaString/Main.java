class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        if(m > n)
            return -1;
        int j;
        for(int i=0;i<=n-m;i++) {
            for(j=0;j<m;j++) {
                if(needle.charAt(j) != haystack.charAt(i+j))
                    break;
            }
            if(j == m)
                return i;
        }
        return -1;
    }
}