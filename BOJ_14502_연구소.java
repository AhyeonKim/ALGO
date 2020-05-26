import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502_연구소 {
	static int N, M;
	static int[][] arr;
	static int[][] copy;
	static int ans;
	static ArrayList<Cell> blank;
	static boolean[] check;
	static Queue<Cell> virus;
	static int[] di = {0,1,0,-1};
	static int[] dj = {-1,0,1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		blank = new ArrayList<>();
		virus = new LinkedList<>();
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int k = sc.nextInt();
				arr[i][j] = k;
				copy[i][j] = k;
				if(arr[i][j]==0) {
					blank.add(new Cell(i,j));
				}else if(arr[i][j]==2) {
					virus.add(new Cell(i,j));
				}
			}
		}
		check = new boolean[blank.size()];
		ans = 0;
		Comb(3,0,0);
		System.out.println(ans);
	}
	public static void Comb(int R, int target, int cnt) {
		if(R==cnt) {
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					arr[blank.get(i).i][blank.get(i).j]=1;					
				}
			}
			int t = bfs();
			if(t>ans) {
				ans=t;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = copy[i][j];
				}
			}
			return;
		}
		if(target == blank.size()) {
			return;	
		}
		check[target] = true;
		Comb(R,target+1,cnt+1);
		check[target] = false;
		Comb(R,target+1,cnt);
	}
	
	private static int bfs() {
		int zero=0;
		while(!virus.isEmpty()) {
			Cell vcell = virus.poll();
			for (int d = 0; d < 4; d++) {
				int ni = vcell.i+di[d];
				int nj = vcell.j+dj[d];
				if(!isOut(ni,nj)) {
					if(arr[ni][nj]==0) {
						arr[ni][nj]=2;
						virus.add(new Cell(ni,nj));
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j]==2) {
					virus.add(new Cell(i,j));
				}
			}
		}
		zero = searchSafe();
		return zero;
	}
	private static boolean isOut(int ni, int nj) {
		if( ni<0 || nj<0 || ni>=N || nj>=M ) {
			return true;
		}else return false;
	}
	public static int searchSafe() {
		int tmp=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0) {
					tmp++;
				}
			}
		}
		return tmp;
	}
	
	public static class Cell {
		int i;
		int j;
		
		public Cell() {
			
		}
		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
