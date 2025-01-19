
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {

            String text = br.readLine();
            String pattern =  br.readLine();
			
            Solver solver = new Solver();		
            
            solver.solve(text, pattern);

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
    final static int N = 50000;
    final static int modular_inverse_P = 129032259;
    
   

	public void solve(String text, String pattern) {					
		// Main.output.append(input);
        int m = pattern.length();
        int n = text.length();
     
        long hash_pattern = 0;
        long hash_text = 0;

        int power = 1;
        for(int i=0;i<m;i++) {
            hash_pattern = (hash_pattern + ((pattern.charAt(i) - 'a' + 1) * power) % MOD) % MOD;
            hash_text = (hash_text + ((text.charAt(i) - 'a' + 1) * power) % MOD) % MOD;
            power = (power*P) % MOD;
        }

        if(m > n) {
            return;
        }

        if(hash_pattern == hash_text) {
            Main.output.append("0 ");
        }

        for(int i = m; i<n;i++) {
            hash_text = (hash_text - (text.charAt(i-m)-'a'+1) + (text.charAt(i)-'a' + 1) * power) % MOD;
            hash_text = (hash_text * modular_inverse_P) % MOD;
            if(hash_pattern == hash_text) {
                Main.output.append(i-m+1).append(" ");
            }
        }

	}
}