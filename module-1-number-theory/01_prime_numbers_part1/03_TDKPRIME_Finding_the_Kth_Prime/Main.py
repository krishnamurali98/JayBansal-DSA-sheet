#!/usr/bin/env python3
import sys

input = sys.stdin.readline 

OFFLINE_TEST = False


def log(*args):
    print("\033[36m", *args, "\033[0m", file=sys.stderr)


def solve(*args):
    # screen input
    if OFFLINE_TEST:
        log("----- solving ------")
        log(*args)
        log("--------------------")
    return solve_(*args)

primes = []
def sieve():
    N = 86028121
    is_prime = [True] * (N+1)
    is_prime[0] = is_prime[1] = False
    i = 2
    while(i*i <= N):
        if (is_prime[i] == True):
            for j in range(i*i, N+1, i):
                is_prime[j] = False
        i += 1
    

    primes.append(-1)
    for i in range(2, N+1):
        if is_prime[i]:
            primes.append(i)




def solve_(k):
    if k <= 0 or k >= len(primes):
        return "Error: k out of bounds"
    return primes[k]


def main():
    sieve()

    for case_num in range(int(input().strip())):
        n = int(input().strip())
        res = solve(n)  # include input hereS
        print(res)


if __name__ == "__main__":
    main()