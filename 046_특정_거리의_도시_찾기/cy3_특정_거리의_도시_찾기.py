input = __import__("sys").stdin.readline
n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n)]
for i in range(m):
  a, b = map(int, input().split())
  graph[a-1].append(b-1)

sd = [0]*n
visited = [False]*n

# do dfs
from collections import deque
dq = deque()
dq.append((x-1, 0)) # city, distance
visited[x-1] = True
while (len(dq) > 0):
  cur, cur_d = dq.popleft()
  sd[cur] = cur_d
  for next_city in graph[cur]:
    if not visited[next_city]:
      dq.append((next_city, cur_d+1))
      visited[next_city] = True

if k not in sd:
  print(-1)
else:
  for i, d in enumerate(sd):
    if d == k:
      print(i+1)

