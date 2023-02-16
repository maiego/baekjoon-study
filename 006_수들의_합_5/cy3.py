n = int(input())
ans = 0; s = 0
for i in range(1, n+1):
  s += i
  if s > n: break
  if (n-s) % i == 0: ans += 1
print(ans)