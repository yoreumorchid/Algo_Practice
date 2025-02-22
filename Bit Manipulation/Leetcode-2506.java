class Solution {
    // First Impression Solution:
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for(String word: words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            StringBuilder pairKey = new StringBuilder();

            // Identify pair key of the current word
            for(char ch: chars) {
                if(pairKey.length() == 0 || pairKey.charAt(pairKey.length() -  1) != ch) {
                    pairKey.append(ch);
                }
            }

            // Update the count for the current pair key
            int n = map.getOrDefault(pairKey.toString(), 0);
            map.put(pairKey.toString(), n + 1);

            result += n;
        }
        return result;
    }
    // Time Complexity: O(n * m log m)
    // Space Complexity: O(n)

    // Optimized Solution:
    public int similarPairs(String[] words) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int byteValue = 0;
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                // 通过将字母集合映射为一个整数code, 字母的顺序不再影响结果, 只要字母组合相同
                // 表示字母在字母表里的位置
                int currentByte = ch - 'a';
                // 左移位操作, 将1向左移动n位
                byteValue |= 1 << currentByte;
            }
            res += map.getOrDefault(byteValue, 0);
            map.put(byteValue, map.getOrDefault(byteValue, 0) + 1);
        }
        return res;
    }
    // Time Complexity: O(n * m)
    // Space Complexity: O(n + m)
}