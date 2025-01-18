class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;

        for(int x : nums) {
            ans = ans ^ x;
        }
        for(int i=0;i<=nums.length;i++) {
              ans = ans ^ i;
        }
        return ans;
    }
}