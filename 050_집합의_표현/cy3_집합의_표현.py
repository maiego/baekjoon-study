# make disjoint set
class union_find():
    def __init__(self, n):
        self.n = n
        self.par = [-1]*n # parent index
    
    def find(self, x):
        """return parent of x"""
        if self.par[x] < 0:
            return x
        # find root
        root = self.par[x]
        while(self.par[root] > 0):
            root = self.par[root]
        # path compression
        cur = x
        while(self.par[cur] > 0):
            next_ = self.par[cur]
            self.par[cur] = root
            cur = next_
        return self.par[x]
    
    def union(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if a != b:
            self.par[a] = b

input = __import__('sys').stdin.readline
n, m = map(int, input().split())
uf = union_find(n+1)
for _ in range (m):
  op, a, b = map(int, input().split())
  if op==0: # union
    uf.union(a, b)
  if op==1: # check same
    if uf.find(a) == uf.find(b):
       print('YES')
    else:
       print('NO')


