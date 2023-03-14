from collections import deque
n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(n + 1):
    graph[i].sort()
  
# DFS
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            visited = dfs(graph, i, visited)
    return visited

# BFS
def bfs(graph, v):
    queue = deque([v])
    visited = [False] * (n + 1)
    visited[v] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

dfs(graph, v, [False] * (n + 1))
print()
bfs(graph, v)

