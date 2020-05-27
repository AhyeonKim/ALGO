import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502_연구소_2 {
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
		Comb();
		System.out.println(ans);
	}
	public static void Comb() {
		for (int i = 0; i < blank.size()-2; i++) {
			for (int j = i+1; j < blank.size()-1; j++) {
				for (int k = j+1; k < blank.size(); k++) {
					System.out.println(i+" "+j+" "+k);
					arr[blank.get(i).i][blank.get(i).j]=1;
					arr[blank.get(j).i][blank.get(j).j]=1;
					arr[blank.get(k).i][blank.get(k).j]=1;
					int t = bfs();
					if(t>ans) {
						ans=t;
					}
					for (int x = 0; x < N; i++) {
						for (int y = 0; y < M; j++) {
							arr[x][y] = copy[x][y];
						}
					}
				}
			}
		}
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
