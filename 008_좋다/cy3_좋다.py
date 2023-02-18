# 해설 참고: https://astrid-dm.tistory.com/m/470
# O(n^2) 인데, n=2000이라 가능. 첨에 n 크기 잘못봐서 안되는줄 알았음
n = int(input())
a = list(map(int, input().split()))
a.sort()
ans = 0
for i in range(n):
  start, end = 0, n-1
  while start < end:
    s = a[start] + a[end]
    if start == i: start += 1
    elif end == i: end -= 1
    elif s < a[i]: start += 1
    elif s > a[i]: end -= 1
    else:
      ans += 1
      break
print(ans)