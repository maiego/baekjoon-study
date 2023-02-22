n = int(input())
from collections import deque
deq = deque([i for i in range(1, n+1)])
while len(deq) > 1:
  deq.popleft()
  deq.append(deq.popleft())
print(deq[0])