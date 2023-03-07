import sys
input = sys.stdin.readline
n, m = map(int, input().split())
adj = [[] for _ in range(n)]
for _ in range(m):
  u, v = map(int, input().split())
  adj[u-1].append(v-1)
  adj[v-1].append(u-1)

visited = [False] * n

def dfs(v):
  visited[v] = True
  for w in adj[v]:
    if not visited[w]:
      dfs(w)

# run dfs for each unvisited vertex
cnt = 0
for v in range(n):
  if not visited[v]:
    dfs(v)
    cnt += 1

print(cnt)