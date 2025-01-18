
P = 7 # 10 ** 9 + 7

def mod_inv(a):
    return pow(a, P - 2)


def pow(a, b):
    if b == 0:
        return 1
    ans = pow(a, b//2)
    ans = (ans * ans) % P
    if b % 2 == 1:
        ans = (ans * a) % P
    return ans


def pow_iterative(a, b):
    ans = 1
    while b > 0:
        if b % 2 == 1:
            ans *= a
        a *= a
        b >>= 1
    return ans



def main():
    t = int(input())
    
    for _ in range(t):
        a, b = map(int, input().split())
        # print(pow(a, b))
        print(pow_iterative(a, b))
        print("***************")
    
    for i in range(1, 7):
        print(mod_inv(i))
       


if __name__ == '__main__':
    main()