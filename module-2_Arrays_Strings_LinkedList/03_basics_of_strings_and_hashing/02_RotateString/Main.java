class Solution {
    public boolean rotateString(String s, String g) {
        if(s.length() != g.length()) {
            return false;
        }
        int n = s.length();
        for(int i=0;i<n;i++) {
            boolean flag = true;
            for(int j=0;j<n;j++) {
                if(s.charAt((i+j)%n) != g.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }
}