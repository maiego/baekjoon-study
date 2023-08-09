n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))
a.sort()
from bisect import bisect_left
for bi in b:
  i = bisect_left(a, bi)
  if i < len(a) and a[i] == bi:
    print(1)
  else:
    print(0)

