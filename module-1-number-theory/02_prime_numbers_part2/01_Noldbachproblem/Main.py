import sys

input = sys.stdin.readline  # to read input quickly


n = 1000
is_prime = [True] * (n + 1)
is_prime[0] = is_prime[1] = False
i = 2
while(i*i <= n):
    if (is_prime[i] == True):
        for j in range(i*i, n+1, i):
            is_prime[j] = False
    i += 1

primes = []
for i in range(2, n+1):
    if is_prime[i]:
        primes.append(i)

noldbach = [False] * (n + 1)
for i in range(len(primes)-1):
    ele = primes[i] + primes[i+1] + 1
    if ele > n:
        break
    if is_prime[ele]:
        noldbach[ele] = True

n, k = map(int, input().split())
c = 0
for i in range(2, n+1):
    if noldbach[i]:
        c += 1

if c >= k:
    print("YES")
else:
    print("NO")