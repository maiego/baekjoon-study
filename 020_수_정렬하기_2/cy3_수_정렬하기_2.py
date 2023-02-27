input = __import__('sys').stdin.readline
n = int(input())
a = [int(input()) for _ in range(n)]
a.sort()
print("\n".join(map(str,a)))