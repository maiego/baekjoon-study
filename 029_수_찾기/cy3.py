input = __import__('sys').stdin.readline
n = int(input())
s = set(map(int, input().split()))
m = int(input())
for i in map(int, input().split()):
    print(1 if i in s else 0)