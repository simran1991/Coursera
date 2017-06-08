import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class coinProblem {
	static int iter=0;
	static int[] table;
	static int[] coinvalues;
	static Map<Integer,Integer> kmap=new HashMap<>();
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return st.nextToken();
		}

		BigInteger nextInt() {
			
			return new BigInteger(next());
		}
	}

	public static void main(String[] args) {
		FastScanner fs = new FastScanner(System.in);
		System.out.println("read Data");
		int maxDenomination = fs.nextInt();
		int numberOfDenominations = fs.nextInt();
		ArrayList<Integer> availableDenominations = new ArrayList<>();
		for (int x = 0; x < numberOfDenominations; x++) {
			availableDenominations.add(fs.nextInt());
		}
		table=new int[maxDenomination+1];
		coinvalues=new int[numberOfDenominations];
		System.out.println(generateSetOfCoins(availableDenominations, maxDenomination));
		for (Integer x:kmap.keySet()){
			System.out.println("no of coins with denomination "+x+" are "+kmap.get(x));
		}
			
	}

	private static int generateSetOfCoins(ArrayList<Integer> availableDenominations, int change) {
		int minCoins = change;
		int numberOfCoins;
		if(table[change]>0)
			return table[change];
		else if (availableDenominations.contains(change)) 
				return 1;
		else {
			for (int x : availableDenominations) {
				if (x <= change) {
					numberOfCoins = 1 + generateSetOfCoins(availableDenominations, change - x);
					kmap.put(change, numberOfCoins);
					if (numberOfCoins < minCoins)
						{
							minCoins = numberOfCoins;
					
						}
				}
			}
			table[change]=minCoins;
			
			return minCoins;
		}
	}
}
