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
    if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and not visited[nx][ny]:
      #########
      # 여기서 visited를 True로 바꿔줘야 시간 초과가 안난다.
      # 왜냐하면, queue에 들어가는 것은 방문하지 않은 곳이기 때문에
      # visited를 True로 바꿔주지 않으면, queue에 중복으로 들어가게 된다.
      #########
      visited[nx][ny] = True
      queue.append((nx, ny, move + 1))