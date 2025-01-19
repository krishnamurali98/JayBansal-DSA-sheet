class Solution {
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length - 1;
        while(m <= h) {
            if(nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else if(nums[m] == 1)
                m++;
            else {
                swap(nums, m, h);
                h--;
            }
        }
    }
}