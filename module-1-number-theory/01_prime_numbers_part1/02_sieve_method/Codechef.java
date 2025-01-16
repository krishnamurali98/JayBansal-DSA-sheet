
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Codechef {
	public static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cases;
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

}
class Solver {
	public void solve(String input) {					
		// Codechef.output.append(input);
		final int N = Integer.parseInt(input);
		boolean[] isPrime = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			isPrime[i] = true;
		}
		for(int i=2;i*i<=N;i++) {
		    if(isPrime[i]) {
		        for(int j=i*i;j<=N;j+=i) {
		            isPrime[j] = false;
		        }
			}
		}

		for(int i=2;i<=N;i++) {
		    if(isPrime[i]) {
		        Codechef.output.append(i).append(" ");
		    }
		}
	}
}