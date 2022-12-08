import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			char[] s = fs.next().toCharArray();
			int[] freq = new int[26];
			Arrays.fill(freq, 0);
			boolean[] visited = new boolean[26];
			Arrays.fill(visited, false);
			int[] indices = new int[26];
			for (int i = 0; i < n; i++) {
				int index = i;
				while (index < n && s[i] == s[index]) {
					index++;
				}
				if (freq[s[i]-'a'] > 0) {
					visited[s[i]-'a'] = true;
				}
				if (index - i > freq[s[i]-'a']) {
					freq[s[i]-'a'] = index - i;
					indices[s[i]-'a'] = i;
				}
				i = index - 1;
			}
			int[] secondMax = new int[26];
			Arrays.fill(secondMax, 0);
			for (int i = 0; i < n; i++) {
				int index = i;
				while (index < n && s[i] == s[index]) {
					index++;
				}
				if (visited[s[i]-'a'] && i != indices[s[i]-'a']) {
					secondMax[s[i]-'a'] = Math.max(secondMax[s[i]-'a'], index - i);
				}
				i = index - 1;
			}
			int best = 0;
			for (int i = 0; i < 26; i++) {
				if (visited[i]) {
					best = Math.max(best, secondMax[i]);
				}
				best = Math.max(best, freq[i] - 1);
			}
			out.println(best);
		}
		out.close();
	}

	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
