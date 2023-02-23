input = __import__('sys').stdin.readline
import heapq
heap = []
ans = []
for _ in range(int(input())):
    x = int(input())
    if x != 0: heapq.heappush(heap, (abs(x), x))
    else:
        if heap: ans.append(heapq.heappop(heap)[1])
        else: ans.append(0)
print(*ans, sep='\n')