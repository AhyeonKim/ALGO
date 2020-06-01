import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {
	static int ans;
	static int N, M;
	static int[] di = {0,-1,0,1};
	static int[] dj = {-1,0,1,0};
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			int j = 0;
			for (char c : str) {
				map[i][j] = c;
				j++;
			}
		}
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='L') {
					visit = new boolean[N][M];
					check(i,j,0);
				}
			}
		}
		System.out.println(ans);
	}
	private static void check(int i, int j, int hour) {
		Queue<Cell> queue = new LinkedList<>();
		visit[i][j] = true;
		queue.add(new Cell(i,j,hour));
		Cell tmp = new Cell();
		while(!queue.isEmpty()) {
			tmp = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ni = tmp.i+di[d];
				int nj = tmp.j+dj[d];
				int nt = tmp.hour+1;
				if(!isOut(ni,nj)&&!visit[ni][nj]&&map[ni][nj]=='L') {
					visit[ni][nj] = true;
					queue.add(new Cell(ni,nj,nt));
				}
			}
		}
		if(tmp.hour>ans) {
			ans = tmp.hour;
		}
	}
	
	private static boolean isOut(int i, int j) {
		if(i<0 || j<0 || i>=N || j>=M) {
			return true;
		}else return false;
	}
	
	public static class Cell{
		int i;
		int j;
		int hour;
		public Cell() {
			// TODO Auto-generated constructor stub
		}
		public Cell(int i, int j, int hour) {
			this.i = i;
			this.j = j;
			this.hour = hour;
		}
	}
}
