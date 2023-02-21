from collections import deque
n = int(input())
a = list(map(int, input().split()))
ans = [-1] * n
stack = deque([0])
for i in range(1,n):
  while stack and a[stack[-1]] < a[i]:
    ans[stack.pop()] = a[i]
  stack.append(i)
print(*ans)