input = __import__('sys').stdin.readline
n = int(input())
a = [int(input()) for _ in range(n)]
a_sorted = sorted(a)
idx_dict = {a_sorted[i]: i for i in range(n)}
shifts=[idx_dict[a[i]]-i for i in range(n)]
max_left_shift = abs(min(shifts))
print(max_left_shift+1)