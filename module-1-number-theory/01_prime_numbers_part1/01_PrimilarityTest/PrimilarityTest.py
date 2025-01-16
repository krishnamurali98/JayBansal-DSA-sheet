
import sys
input = sys.stdin.readline  # to read input quickly

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


# ---------------------------- template ends here ----------------------------


def solve_(n):
    # your solution here
    if n <= 1:
        return "no"
    i = 2
    while i*i <= n:
        if n % i == 0:
            return "no"
        i+=1
    return "yes"

for case_num in range(int(input())):
    n = int(input())
    res = solve(n)
    print(res)