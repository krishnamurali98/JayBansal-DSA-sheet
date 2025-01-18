MOD = 10 ** 9 + 7
N = 10 ** 5
f = []
inv_f = []

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

def pre_factorial():
    f.append(1)
    for i in range(1, N+1):
        a = (i * f[i-1]) % MOD
        f.append(a)

def pre_modular_inverse():
    global inv_f
    inv_f.append(mod_inv(f[N]))

    i = N-1
    while i >=0:
        a = ((i+1) * inv_f[-1]) % MOD
        inv_f.append(a)
        i -= 1

    inv_f.reverse()
    

def ncr(n, r):
    if r > n:
        return 0;

    a = f[n]
    b = inv_f[n-r] % MOD
    c = inv_f[r] % MOD
    ans = (a*b*c) % MOD
    return ans


def main():
    pre_factorial()
    pre_modular_inverse()
    
    t = int(input())
    for _ in range(t):
        n, r = map(int, input().split())
        print(ncr(n, r))

if __name__ == '__main__':
    main()