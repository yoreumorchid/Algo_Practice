class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // 按照出现次数划分层数
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int maxCount = Collections.max(count.values());
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= maxCount; i++) {
            // 添加行
            res.add(new ArrayList<>());
        }

        // 每个元素将要插入的行
        Map<Integer, Integer> index = new HashMap<>();
        for(int num: nums) {
            int rowIndex = index.getOrDefault(num, 0);
            res.get(rowIndex).add(num);
            // 下一次放入不同的行
            index.put(num, rowIndex + 1);
        
        }

        return res;

    }
}

// Time Complexity: O(n)
// Space Complexity: O(k)