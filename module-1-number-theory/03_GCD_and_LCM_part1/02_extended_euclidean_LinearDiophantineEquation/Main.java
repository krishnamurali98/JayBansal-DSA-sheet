
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
	public int ex_gcd(int a, int b, int[] solution) {
		if (b == 0) {
			solution[0] = 1; // x
 			solution[1] = 0; // y can be any number
			return a;
		}
		
		int[] temp = new int[2];
		int g = ex_gcd(b, a % b, temp);
		solution[0] = temp[1];
		solution[1] = temp[0] - (a / b) * temp[1];
		return g;
		
	}
    
    
    public void solve(int caseNumber, String input) {					
		String[] inputs = input.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);

		int[] solution = new int[2];
        int g = ex_gcd(a, b, solution);
        int l = c % g;

        Main.output.append("Case ").append(caseNumber + 1).append(": ");
        if(l == 0) {
            Main.output.append("Yes").append("\n").append(solution[0] * (c / g)).append(" ").append(solution[1] * (c / g)).append("\n");
        } else {
            Main.output.append("No").append("\n");
        }
	}
}