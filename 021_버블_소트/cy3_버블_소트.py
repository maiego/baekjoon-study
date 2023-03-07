# segment tree
# n번째 수에 대하여, 자기 오른쪽에 자기보다 큰 게 몇 개 있는지 구하면 된다.
# 소트 한 뒤에 index를 보면, 오른쪽에 나보다 컸던 수들은 소트 상에서는 내 왼쪽에 있으면서 index가 큰 수들이다.

# sum p[0..pos]
def sum(p, pos):
    pos+=1
    ret = 0
    while(pos > 0):
        ret += p[pos]
        pos &= (pos-1)  # 마지막 비트 지우기
    return ret

# add val to p[pos] 
def add(p, pos, val):
    pos+=1
    while(pos < len(p)):
        p[pos] += val
        pos += (pos & -pos) # 최하위 비트 더하기

seg_tree = [0] * (int(5e+5)+2)
n = int(input())
a = list(map(int, input().split()))
s = sorted(range(0, n), key=lambda k: a[k])
ret = 0
for i in range(n):
  ret += sum(seg_tree, int(5e+5))-sum(seg_tree, s[i]) # 내 오른쪽의, 나보다 큰 수들의 개수
  add(seg_tree, s[i], 1) # 내 index를 추가
print(ret)