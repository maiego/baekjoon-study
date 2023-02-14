input = __import__('sys').stdin.readline
n, m = map(int, input().split())
mat = [list(map(int, input().split())) for _ in range(n)]
sum_mat = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        sum_mat[i][j] = sum_mat[i - 1][j] + sum_mat[i][j - 1] - sum_mat[i - 1][j - 1] + mat[i - 1][j - 1]
for _ in range(m):
  i, j, x, y = map(int, input().split())
  print(sum_mat[x][y] - sum_mat[i - 1][y] - sum_mat[x][j - 1] + sum_mat[i - 1][j - 1])