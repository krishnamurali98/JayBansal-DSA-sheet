
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cases;
		try {
			cases = Integer.parseInt(br.readLine().trim());
			Solver solver = new Solver();
			for (int i = 0; i < cases; i++) {				
				solver.solve(i, br.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Print the final output
		System.out.println(output.toString().trim());
	}

}
class Solver {
	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
    
    
    public void solve(int caseNumber, String input) {					
		String[] inputs = input.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

        int g = gcd(a, b);
        int l = c % g;

        Main.output.append("Case ").append(caseNumber + 1).append(": ");
        if(l == 0) {
            Main.output.append("Yes").append("\n");
        } else {
            Main.output.append("No").append("\n");
        }
	}
}