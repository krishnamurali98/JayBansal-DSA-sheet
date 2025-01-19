import java.util.ArrayList;
import java.util.HashMap;

class Prefix {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int diff = target-nums[i];
            if(m.containsKey(diff))
                return new int[]{m.get(diff), i};
            m.put(nums[i], i);
        }
        return new int[]{-1, -1};       
    }
}


class SortAndTwoPointer {
    public int[] twoSum(int[] nums, int k) {
        
        ArrayList<int[]> arr = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            arr.add(new int[]{nums[i], i});
        }
        
        arr.sort((a, b) -> a[0]-b[0]);
        
        int i=0, j = nums.length-1;
        while(i < j) {
            int s = arr.get(i)[0] + arr.get(j)[0];
            if(s == k) {
                return new int[]{arr.get(i)[1], arr.get(j)[1]};
            } else if(s > k) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{-1, -1};      
    }
}