
def gauss(n):
    phi = [i for i in range(n+1)]
    for i in range(1, n+1):
        for j in range(2*i, n+1, i):
            phi[j] -= phi[i]
    return phi


def main():
    n = int(input())
    phi = gauss(n)
    print(phi)


if __name__ == '__main__':
    main()