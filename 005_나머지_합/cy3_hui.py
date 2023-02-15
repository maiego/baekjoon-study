# https://justicehui.github.io/ps/2019/04/04/BOJ10986/ 해설 참고
n, m = map(int, input().split())
a = list(map(int, input().split()))
cnt = [0]*(m+1)
s = 0
for i in range(n):
  s += a[i]
  s%=m
  cnt[s] += 1
ans = cnt[0]
for i in range(m):
  ans += cnt[i]*(cnt[i]-1)//2
print(ans)