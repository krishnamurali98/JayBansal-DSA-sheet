
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	public static StringBuilder output = new StringBuilder();
    
    final static int msm = 31623;
    static boolean[] primes = new boolean[msm+1];  // -----> related to M
    static ArrayList<Integer> primeNumbers = new ArrayList<>();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cases;

        sieve();

		try {
			cases = Integer.parseInt(br.readLine().trim());
			Solver solver = new Solver();
			for (int i = 0; i < cases; i++) {				
				solver.solve(br.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Print the final output
		System.out.println(output.toString().trim());
	}

    public static void sieve() {
        for(int i=0;i<primes.length;i++) {
            primes[i] = true;
        }

        primes[0] = primes[1] = false;
        for(int i=2;i*i<primes.length;i++) {
            if(primes[i]) {
                for(int j=i*i;j<primes.length;j+=i) {
                    primes[j] = false;
                }
            }
        }

        for(int i=2;i<=msm;i++) {
            if(primes[i])
                primeNumbers.add(i);
        }
    }

}
class Solver {
	  
    static boolean[] primesBetweenNandM = new boolean[100001];

    public static void segmented_sieve(int N, int M) {
        int limit = (int) Math.floor(Math.sqrt(M));
        
        for(int i=0;i<M-N+1;i++) {
            primesBetweenNandM[i] = true;
        }

        if(N == 1)
            primesBetweenNandM[0] = false;

        for(int i : Main.primeNumbers) {
            if(i > limit)
                break;

            int start = (int) Math.floor((double) N/i)*i;
            if(start < N)
                start += i;
            if(start < i*i)
                start = i*i;

            for(int j=start;j<=M;j+=i) {
                primesBetweenNandM[j-N] = false;
            }
        }

        for(int i=0;i<M-N+1;i++) {
            if(primesBetweenNandM[i])
                Main.output.append(i+N).append("\n");
        }
        Main.output.append("\n");
    }
    
    
    public void solve(String input) {					
		// Codechef.output.append(input);
        String[] inputs = input.split(" ");
        
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        segmented_sieve(N, M);
	}
}