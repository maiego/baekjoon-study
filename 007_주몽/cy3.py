n, m = int(input()), int(input())
arr = list(map(int, input().split()))
arr.sort()
start = 0; end = n-1
ans = 0
while start < end:
  if arr[start]+arr[end] == m:
    ans += 1
    start += 1
    end -= 1
  elif arr[start]+arr[end] < m: start += 1
  else: end -= 1
print(ans)