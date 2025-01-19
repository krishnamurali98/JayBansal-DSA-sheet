
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashSet;

class Main {
	public static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cases;
		
        Solver.preComputePowers();
        
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
    final static int MOD = 1000000007;
    final static int P = 31;
    final static int N = 100000;

    static long[] powers;
    public static void preComputePowers() {
        powers = new long[N+1];
        Arrays.fill(powers, 1);

        for(int i=1;i<N+1;i++) {
            powers[i] = (powers[i-1]*P) % MOD;
        }
    }


    private long hash(String s) {
        long ans = 0;
        for(int i=0;i<s.length();i++) {
            ans = (ans + (s.charAt(i)-'a'+1) * powers[i]) % MOD; 
        }
        return ans;
    }

    private long number_of_unique_substrings(String s) {
        int n = s.length();
        HashSet<Long> ans = new HashSet<>();
        for(int i=0;i<n;i++) {
            long last_hash = 0;
            for(int j=i;j<n;j++) {
                last_hash = (last_hash + (s.charAt(i)-'a'+1) * powers[j-i]) % MOD;
                ans.add(last_hash);
            }
        }
        return ans.size();
    }



	public void solve(String input) {					
        Main.output.append(number_of_unique_substrings(input)).append("\n");
	}
}