import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {
	static int M;
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 가로 칸의 수
		N = sc.nextInt(); // 세로 칸의 수
		arr = new int[M][N];
		visit = new boolean[M][N];
		Queue<Tomato> tomato = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==1) {
					visit[i][j] = true;
					tomato.add(new Tomato(i,j,0));
				}
			}
		}
		int ans = 0;
		boolean flag1 = false;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==0) {
					flag1 = true;
					break;
				}
			}
		}
		if(flag1) {
			while(!tomato.isEmpty()) {
				Tomato t = tomato.poll();
				for (int d = 0; d < 4; d++) {
					int ni = t.x+di[d];
					int nj = t.y+dj[d];
					if(!isOut(ni,nj) && !visit[ni][nj]) {
						visit[ni][nj] = true;
						if(arr[ni][nj]==1) {
							tomato.add(new Tomato(ni,nj,++t.day));
						}
					}
				}
				ans = t.day;
			}
		}
		
		boolean flag2 = false;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(visit[i][j]==false) {
					flag2 = true;
					break;
				}
			}
		}
		if(!flag1) {
			System.out.println(0);
		}else if(flag2) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
		
	}
	public static class Tomato{
		int x;
		int y;
		int day;
		
		public Tomato() {
			// TODO Auto-generated constructor stub
		}
		public Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.day = z;
		}
	}
	public static boolean isOut(int i, int j) {
		if(i<0 || j<0 | i>=M || j>=N) {
			return true;
		}else return false;
	}
}
