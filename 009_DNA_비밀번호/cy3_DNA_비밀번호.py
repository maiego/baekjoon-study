s, p = map(int, input().split())
dna = input()
min_ACGT = list(map(int, input().split()))
cur_ACGT = [0, 0, 0, 0]
ACGT_dict = {'A': 0, 'C': 1, 'G': 2, 'T': 3}
for i in range(p-1):
  cur_ACGT[ACGT_dict[dna[i]]] += 1
ans = 0
for i in range(p-1, s):
  cur_ACGT[ACGT_dict[dna[i]]] += 1
  if all(cur_ACGT[j] >= min_ACGT[j] for j in range(4)): ans += 1
  cur_ACGT[ACGT_dict[dna[i-p+1]]] -= 1
print(ans)