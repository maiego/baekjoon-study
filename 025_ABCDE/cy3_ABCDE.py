n, m = map(int, input().split())
adj = [[] for _ in range(n)]
for _ in range(m):
  u, v = map(int, input().split())
  adj[u].append(v)
  adj[v].append(u)

import copy
def dfs(v, visited=set()):
  visited.add(v)
  if len(visited) == 5:
    print(1); exit()
  for w in adj[v]:
    if w not in visited:
      dfs(w, copy.deepcopy(visited))

for i in range(n):
  dfs(i, set())
print(0)