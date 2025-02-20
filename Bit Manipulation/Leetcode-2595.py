# Optimized Solution:
class Solution(object):
    def evenOddBit(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        odd = 0
        even = 0
        index = 0
        while(n > 0):
            if n % 2 == 1:
                if index % 2 == 0:
                    even += 1
                else:
                    odd += 1
            n //= 2
            index += 1
        return [even, odd]
    
# Time Complexity: O(log n) 每次右移一位直到n为0
# Space Complexity: O(1)
