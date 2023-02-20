import sys
input = sys.stdin.readline
n = int(input())
ans = []
cur = 0
pop = 0
for _ in range(n):
  i = int(input())
  if pop==n:
    if i < cur: cur = i
    else: print("NO"); exit()
  else:
    if cur < i:
      ans+=["+"]*(i-cur)
      ans+=["-"]
      cur = i; pop += 1
    elif cur > i:
      ans.append("-")
      pop += 1
    if i == n:
      ans+=["-"]*(n-pop)
      cur = n; pop = n
print("\n".join(ans))  