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

def mods(a, b):
    while len(a) >= len(b) and a[:len(b)] == b:
        a = a[len(b):]
    return a

def gcd(a, b):
    if b == '':
        return a

    mod = mods(a, b)
    if len(mod) >= len(b):
        return ''
    return gcd(b, mod)

def solve_(str1, str2):
    if(len(str1) > len(str2)):
        return gcd(str1, str2)
    return gcd(str2, str1)


for case_num in range(int(input())):
    str1, str2 = input().split()
    res = solve(str1, str2) 
    print(res)