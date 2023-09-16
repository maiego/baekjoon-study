n, m = map(int, input().split())
lecture_lengths = list(map(int, input().split()))

def check(bluelay_length):
    """
    Checks given bluelay length can fit to lectures
    """
    cur_m = 1
    cur_len = 0
    for l in lecture_lengths:
      if l > bluelay_length:
         return False
      if cur_len + l > bluelay_length:
        # use new blueray
        cur_len = l
        cur_m += 1
      else:
        cur_len += l
    return True if cur_m <= m else False

# do bisect
lo, hi = 0, int(1e9)+1
while (hi-lo) > 1:
   mid = (lo+hi)//2
   if check(mid):
      hi = mid
   else:
      lo = mid
print(hi)
