import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_14502_연구소 {
	static int N, M;
	static int[][] arr;
	static int ans;
	static ArrayList<Blank> blank;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		blank = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==0) {
					blank.add(new Blank(i,j));
				}
			}
		}
		
		check = new boolean[blank.size()];
		Comb(3,0,0);
		
		
		System.out.println(ans);
	}
	public static void Comb(int R, int target, int cnt) {
		if(R==cnt) {
			blank.get()
		}else if(target==blank.size()-1) {
			
		}
		
		check[target] = true;
		Comb(R,target+1,cnt+1);
		check[target] = false;
		Comb(R,target+1,cnt);
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
	
	public static class Blank {
		int i;
		int j;
		
		public Blank() {
			
		}
		public Blank(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
