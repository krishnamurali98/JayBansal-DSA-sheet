import java.util.HashMap;

class BruteForce {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum += nums[j];
                if(sum == k)
                    ans++;
            }
        }
        return ans;
    }
}

class PrefixSum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        
        int sum = 0;
        int ans = 0;

        for(int n : nums) {
            sum += n;
            if(hm.containsKey(sum-k)) {
                ans += hm.get(sum-k);
            } 

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}