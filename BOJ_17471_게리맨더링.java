import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	
	static int N;
	static int[] city;
	static int[][] connect;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		city = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		connect = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			String[] str = s.split(" ");
			int k = 0;
			for (int j = 0; j < Integer.parseInt(str[k]); j++) {
				connect[i][Integer.parseInt(str[k++])] = 1;
			}
		}
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N/2; i++) {
			Comb(i,)
		}
		
		System.out.println(min);
	}
	
	public static void Comb() {
		
	}
	
	public static boolean isConnect() {
		
	}
}
