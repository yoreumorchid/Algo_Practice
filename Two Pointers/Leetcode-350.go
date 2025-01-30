// First Impression Solution:
func intersect(nums1 []int, nums2 []int) []int {
	if len(nums1) > len(nums2) {
		nums1, nums2 = nums2, nums1
	}
	countMap := make(map[int]int)
	result := []int{}
	for _, num := range nums1 {
		countMap[num]++
	}
	for _, num := range nums2 {
		if countMap[num] > 0 {
			result = append(result, num)
			// 如果出现次数不一致，则考虑取较小值
			countMap[num]--
		}
	}
	return result
}

// Time Complexity: O(n + m) 主要来自于对两个数组的遍历
// Space Complexity: O(n)
// Optimized Solution:
func intersect(nums1 []int, nums2 []int) []int {
	if len(nums1) > len(nums2) {
		nums1, nums2 = nums2, nums1
	}

	sort.Ints(nums1)
	sort.Ints(nums2)
	result := []int{}
	i, j := 0, 0

	// 双指针
	for i < len(nums1) && j < len(nums2) {
		if nums1[i] == nums2[j] {
			result = append(result, nums1[i])
			i++
			j++
		} else if nums1[i] < nums2[j] {
			i++
		} else {
			j++
		}
	}
	return result
}

// Time Complexity: O(n log n + m log m) 主要来自于对两个数组的排序
// Space Complexity: O(1)