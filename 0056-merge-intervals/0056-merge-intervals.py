class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        ans = []
        i = 0
        intervals.sort()
        while i < len(intervals):
            currEnd = intervals[i][1]
            j = i + 1
            while j < len(intervals) and intervals[j][0] <= currEnd:
                currEnd = max(currEnd, intervals[j][1])
                j += 1
            
            ans.append([intervals[i][0], currEnd])
            i = j

        return ans
        