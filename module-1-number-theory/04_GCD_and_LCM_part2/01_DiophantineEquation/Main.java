
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
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
	
    public static int ex_gcd(int a, int b, int[] solutions) {
        if(b == 0) {
            solutions[0] = 1;
            solutions[1] = 0;
            return a;
        }
        int[] temp = new int[2];
        int gcd = ex_gcd(b, a % b, temp);
        solutions[0] = temp[1];
        solutions[1] = temp[0] - temp[1] * (a / b);
        return gcd;
    }
    
    public void solve(String input) {					
		String[] inputs = input.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int c = Integer.parseInt(inputs[2]);
    
        int[] solutions = new int[2];
        int gcd = ex_gcd(a, b, solutions);
        if (c % gcd == 0) {
            // Scale the solutions to satisfy the equation a * x + b * y = c
            int x1 = solutions[0] * (c / gcd);
            int y1 = solutions[1] * (c / gcd);
            
            // Step size for x and y
            int stepX = b / gcd;
            int stepY = a / gcd;
            
            // Calculate bounds for k
            int lowerK = (int) Math.ceil(-1.0 * x1 / stepX);
            int upperK = (int) Math.floor(1.0 * y1 / stepY);
            
            if (lowerK > upperK) {
                Main.output.append("No").append("\n");
            } else {
                int totalSolutions = upperK - lowerK + 1;
                Main.output.append(totalSolutions).append("\n");
                for (int k = lowerK; k <= upperK; k++) {
                    int x = x1 + k * stepX;
                    int y = y1 - k * stepY;
                    Main.output.append(x).append(" ").append(y).append("\n");
                }
            }
        } else {
            Main.output.append("No").append("\n");
        }
        Main.output.append("**********************\n");
	}
}