from collections import deque
n, m = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

# start from (0, 0) with 1 move
cur = (0, 0, 1)
visited[0][0] = True
dxdy = [(0, 1), (1, 0), (0, -1), (-1, 0)]
queue = deque([cur])
while queue:
  cur = queue.popleft()
  x, y, move = cur
  # check if it is the end
  if x == n - 1 and y == m - 1:
    print(move)
    break
  # add next moves
  for dx, dy in dxdy:
    nx, ny = x + dx, y + dy
    if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and visited[nx][ny]:
      visited[nx][ny] = True
      queue.append((nx, ny, move + 1))