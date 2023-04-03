n, m  = map(int, input().split())
a = list(map(int, input().split()))

# greedy check if it is possible to make m lessons with min_len
def check(min_len, num_of_blueray):
  time = 0
  cnt = 0
  for i in a:
    time += i
    if time > min_len:
      time = i
      cnt += 1
  return True if cnt < num_of_blueray else False

lo, hi = 0, n*10000+1
while lo + 1 < hi:
  mid = (lo + hi) // 2
  if check(mid, m):
    hi = mid
  else:
    lo = mid

print(hi)