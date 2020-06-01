import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
	static int ans;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			int j = 0;
			for (char c : str) {
				map[i][j] = c;
				j++;
			}
		}
		/*for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}*/
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='L') {
					check(i,j);
				}
			}
		}
		
	}
	private static void check(int i, int j) {
		
	}
	
	private static boolean isOut(int i, int j) {
		if(i<0 || j<0 || i>=N || j>=M) {
			return true;
		}else return false;
	}
}
