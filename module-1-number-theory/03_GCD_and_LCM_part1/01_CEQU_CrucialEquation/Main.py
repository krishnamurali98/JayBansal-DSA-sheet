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

def gcd(a,b):
    if b == 0:
        return a
    return gcd(b,a%b)


def solve_(a,b,c):
    g = gcd(a,b)
    l = c%g
    if l == 0:
        return True
    return False

def main():
    for case_num in range(int(input())):
        a,b,c = map(int, input().split())
        res = solve(a,b,c) 
        if res == True:
            print(f"Case {case_num+1}: Yes")
        else:
            print(f"Case {case_num+1}: No")

if __name__ == "__main__":
    main()