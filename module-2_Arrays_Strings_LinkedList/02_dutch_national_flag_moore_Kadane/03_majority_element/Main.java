class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == res)
                count++;
            else
                count--;
            if(count == 0) {
                res = nums[i];
                count = 1;
            }
        }

        int c = 0;
        for(int x : nums) {
            if(res == x)
                c++;
        }

        if(c > nums.length/2)
            return res;
        return -1;

    }
}