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

def solve_():

    return ""

for case_num in range(int(input())):
    # read line as an integer
    # n = int(input())
    # k = int(input())

    res = solve()  # include input here

    print(res)