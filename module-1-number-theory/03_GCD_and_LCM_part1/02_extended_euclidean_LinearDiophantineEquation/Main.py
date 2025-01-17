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

def ex_gcd(a, b):
    if b == 0:
        return (1, 0, a)
    else:
        x, y, gcd = ex_gcd(b, a % b)
        return (y, x - (a // b) * y, gcd)

def solve_(case_num, a, b, c):
    x0, y0, gcd = ex_gcd(a, b)
    l = c % gcd
    if l == 0:
        print(f"Case: {case_num+1} Solutions : {x0 * (c // gcd)}, {y0 * (c // gcd)}")
    else:
        print(f"Case: {case_num+1} No Solution")

    
def main():
    for case_num in range(int(input())):
        a, b, c = map(int, input().split())
        solve(case_num, a, b, c)


if __name__ == "__main__":
    main()