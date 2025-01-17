
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Codechef {
	public static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String[] input;
		final String[] dishes;
        try {
            
            String firstLine = br.readLine();
            
            if (firstLine == null || firstLine.trim().isEmpty()) {
                throw new IllegalArgumentException("No input provided for cases or dishes.");
            }
            
            input = firstLine.trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);
            
            String secondLine = br.readLine();
            
            if (secondLine == null || secondLine.trim().isEmpty()) {
                throw new IllegalArgumentException("No dishes provided.");
            }
            
            dishes = secondLine.trim().split(" ");
            
            ArrayList<Integer> intDishes = new ArrayList<>();
            intDishes.add(-1);

            for (String dish : dishes) {
                intDishes.add(Integer.parseInt(dish));
            }

            int[] prefixSweetness = new int[n+1];
            Arrays.fill(prefixSweetness, 0);

            for (int i = 1; i < n+1; i++) {
                prefixSweetness[i] = prefixSweetness[i-1];
                if(Solver.isPrime(Solver.phi(intDishes.get(i)))) {
                    prefixSweetness[i] += 1;
                }
            }

			Solver solver = new Solver();
			for (int i = 0; i < q; i++) {				
                String queryLine = br.readLine();
                if (queryLine == null || queryLine.trim().isEmpty()) {
                    throw new IllegalArgumentException("Missing query input.");
                }
                solver.solve(prefixSweetness, queryLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Print the final output
		System.out.println(output.toString().trim());
	}

  

}
class Solver {
    public static boolean isPrime(int n) {
		if(n == 1) 
            return false;
		for(int i=2;i*i<=n;i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
    
    public static int phi(int n) {
        int ans = n;
        for(int i=2;i*i<=n;i++) {
            if(n%i == 0) {
                while(n%i == 0) {
                    n = n/i;
                }
                ans = ans-ans/i;
            }
        }
        if(n > 1) {
            ans = ans-ans/n;
        }
        return ans;
    }
    
    public void solve(int[] prefix, String input) {					
        String[] inputs = input.trim().split(" ");
        int l = Integer.parseInt(inputs[0]);
        int r = Integer.parseInt(inputs[1]);

        int ans = prefix[r]-prefix[l-1];


        Codechef.output.append(ans).append("\n");
	}
}