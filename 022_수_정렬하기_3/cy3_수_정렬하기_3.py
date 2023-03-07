import sys
input = sys.stdin.readline
output = sys.stdout.write
n = int(input())
c = [0] * 10001
for _ in range(n):
    c[int(input())] += 1
for i in range(10001):
    for _ in range(c[i]):
        output(str(i) + '\n')