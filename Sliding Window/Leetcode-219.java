class Solution {
    // First Impression Solution:
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) {
            return false;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while(j <= i + k && j < nums.length) {
                if(nums[i] == nums[j]) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    // Optimized Solution:
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) {
            return false;
        }
        // 利用HashSet来优化滑动窗口
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)  {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(k)

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)

    
}