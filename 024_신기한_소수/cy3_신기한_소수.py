n = int(input())
ans = ['2', '3', '5', '7']

def is_prime(n):
    if n == 1: return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0: return False
    return True

for i in range(1, n):
  new_ans = []
  for a in ans:
    for j in range(10):
      if is_prime(int(a + str(j))):
        new_ans.append(a + str(j))
  ans = new_ans
print("\n".join(ans))