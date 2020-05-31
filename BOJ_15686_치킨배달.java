import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	static int N,M;
	static int[][] map;
	static int[] selected;
	static List<Cell> homes, stores;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		homes = new LinkedList<>();
		stores = new LinkedList<>();
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) {
					homes.add(new Cell(i,j));
				}else if(map[i][j]==2) {
					stores.add(new Cell(i,j));
				}
			}
		}
		selected = new int[M];
		comb(selected, 0, 0);
		
		System.out.println(ans);
	}
	
	public static class Cell{
		int x;
		int y;
		
		public Cell() {
		}
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void comb(int[] selected, int cnt, int target) {
		if(cnt==M) {
			int chicken_d = 0;
			for (int i = 0; i < homes.size(); i++) {
				int distance = Integer.MAX_VALUE;
				for (int j = 0; j < selected.length; j++) {
					int tmpd = getDistance(homes.get(i), stores.get(selected[j]));
					if(tmpd<distance) {
						distance = tmpd;
					}
				}
				chicken_d += distance;
			}
			if(chicken_d<ans) {
				ans = chicken_d;
			}
			return;
		}else if(target==stores.size()) {
			return;
		}
		
		selected[cnt]=target;
		comb(selected,cnt+1, target+1);
		comb(selected,cnt, target+1);
	}
	
	public static int getDistance(Cell c1, Cell c2) {
		int d = 0;
		d = Math.abs(c1.x-c2.x) + Math.abs(c1.y-c2.y);
		return d;
	}

}
