# https://donggoolosori.github.io/2020/10/12/boj-1167/
# 트리에서 가장 먼 두 노드의 거리를 구하기
# 가장 긴 노드 경로를 기준으로 트리를 쭉 펴면, 
# 중간에 뻗어나오는 선들이 존재한다.
# 어디서 시작하든 가장 먼 곳은 가장 긴 경로의 양 끝 중 하나이다.
# 따라서, 임의의 노드에서 가장 먼 노드를 찾고, 그 노드에서 가장 먼 노드를 찾으면
# 그 두 노드 사이의 거리가 트리의 지름이 된다.

input = __import__("sys").stdin.readline
from collections import deque
v = int(input())
graph = [[] for _ in range(v + 1)]
for _ in range(v):
    a, *b = map(int, input().split())
    for i in range(0, len(b) - 1, 2):
        graph[a].append((b[i], b[i + 1]))

def bfs(node):
  visited = [False] * (v + 1)
  max_node, max_depth = 0, 0
  q = deque([(node, 0)])
  visited[node] = True
  while q:
      node, depth = q.popleft()
      if max_depth < depth:
          max_depth = depth
          max_node = node
      for n, d in graph[node]:
          if not visited[n]:
              visited[n] = True
              q.append((n, depth + d))
  return max_node, max_depth

n, _ = bfs(1)
_, d = bfs(n)
print(d)