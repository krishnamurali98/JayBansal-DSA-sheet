
N = 1000000
phi = [i for i in range(N+1)]
def ETF():  
    for i in range(2, N+1):
        if phi[i] == i:
            for j in range(i, N+1, i):
                phi[j] -= phi[j] // i

def main():
    ETF() #precomputes all values of phi

    t = int(input())
    for _ in range(t):
        n = int(input())
        print(phi[n])
    

if __name__ == "__main__":
    main()