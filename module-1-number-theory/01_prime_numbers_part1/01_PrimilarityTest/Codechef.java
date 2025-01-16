
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
        int n = Integer.parseInt(input);
        if(n <= 1) {
            Codechef.output.append("no\n");
            return;
        }
        for(int i=2;i*i <= n;i++){
            if(n%i==0){
                Codechef.output.append("no\n");
                return;
            }
        }
        Codechef.output.append("yes\n");
	}
}

