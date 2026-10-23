import heapq
import math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        heap = []
        res = []

        origin = [0,0]

        dmap = {}

        for i in range(len(points)) :
            dmap[i] = -1 * math.dist(origin, points[i])

        for i,d in dmap.items():
            heapq.heappush(heap,(d,i))
            if(len(heap) > k):
                heapq.heappop(heap)
        

        for d,i in heap:
            res.append(points[i])

        return res
