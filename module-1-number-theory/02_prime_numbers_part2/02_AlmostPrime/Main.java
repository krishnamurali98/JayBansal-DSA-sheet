
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static final int N = 3000;
	public static StringBuilder output;
    static boolean[] primes;
    static int[] primeCount;

	public static void main(String[] args) {
		output = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sieve();
        preComputedPrimeDivisors();

		try {
			Solver solver = new Solver();		
            solver.solve(br.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Print the final output
		System.out.println(output.toString());
	}

    public static void preComputedPrimeDivisors() {
        primeCount = new int[N+1];
        for(int i=2;i<=N;i++) {
            if(primes[i]) {
                for(int j=i;j<=N;j+=i) {
                    primeCount[j]++;
                }
            }
        }
    }

    public static void sieve() {
        primes  = new boolean[N+1];
        for(int i=0;i<=N;i++)
            primes[i]=true;

        primes[0]=primes[1]=false;
        for(int i=2;i*i<=N;i++) {
            if(primes[i]) {
                for(int j=i*i;j<=N;j+=i)
                    primes[j]=false;
            }
        }
    }   
}

class Solver {
	public void solve(String input) {					
		int ans = 0;
        
        int n = Integer.parseInt(input.trim());
        for(int i=1;i<=n;i++) {
            if(Main.primeCount[i]==2)
                ans++;
        }
        Main.output.append(ans).append("\n");
	}
}