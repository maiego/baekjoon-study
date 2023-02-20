# https://yabmoons.tistory.com/630
# 현재 슬라이드 윈도우 안에 최솟값이 앞에 존재할 때, 뒤에 있는 값들은 자기보다 작은 수가 나오면 그 전 수들을 무시할 수 있다.
# deque를 사용해, 큰 값들은 pop 시키고 작은 값들은 맨 앞에 넣는다.
from collections import deque
n, l = map(int, input().split())
a = list(map(int, input().split()))
deq = deque([a[0]])
ans = [a[0]]
for i in range(1, n):
    if i >= l and a[i-l] == deq[0]:
        deq.popleft()
    while deq and deq[-1] > a[i]:
        deq.pop()
    deq.append(a[i])
    ans.append(deq[0])
print(*ans)