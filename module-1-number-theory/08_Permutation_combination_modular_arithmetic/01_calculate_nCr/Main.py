MOD = 10 ** 9 + 7

def pow(a, b):
    ans = 1
    while b > 0:
        if b % 2 == 1:
            ans = (ans*a)%MOD
        a = (a*a) % MOD
        b >>= 1
    return ans

def mod_inv(a):
    return pow(a, MOD-2)

def factorial(n):
    ans = 1
    for i in range(1, n+1):
        ans = (ans*i)%MOD
    return ans

def ncr(n, r):
    if r > n:
        return 0;

    a = factorial(n)
    b = mod_inv(factorial(n-r)) % MOD
    c = mod_inv(factorial(r)) % MOD
    ans = (a*b*c) % MOD
    return ans



def main():
    n, r = map(int, input().split())
    print(ncr(n, r))

if __name__ == '__main__':
    main()