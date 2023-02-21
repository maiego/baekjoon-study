from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
stack = deque()
ans = []
cur = 0
for _ in range(n):
  i = int(input())
  if cur < i:
    for j in range(cur+1, i):
      stack.append(j)
      ans.append("+")
    ans+=["+","-"]
    cur = i
  else:
    if stack[-1] == i:
      stack.pop()
      ans.append("-")
    else:
      print("NO")
      exit()
print("\n".join(ans))