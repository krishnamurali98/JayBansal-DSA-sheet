
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	public static StringBuilder output = new StringBuilder();
    public static ArrayList<Integer> primes;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cases;

        primes = sieve();

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
		System.out.println(output.toString());
	}

    public static ArrayList<Integer> sieve() {
        final int N = 86028121;
        boolean[] isPrime = new boolean[N+1];
        for(int i = 2; i < N+1; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i*i <= N; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(-1);
        for(int i = 2; i < N+1; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

}
class Solver {
	public void solve(String input) {	
        int k = Integer.parseInt(input);				
        Main.output.append(Main.primes.get(k)).append("\n");
	}
}