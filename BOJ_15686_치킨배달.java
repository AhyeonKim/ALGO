import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	static int N,M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt(); //치킨집 개수 1<=M<=13
		List<Cell> homes = new LinkedList<>();
		List<Cell> stores = new LinkedList<>();
//		selected = List<>();
//		for (int i = 0;i < indexlist.length,i++) {
//			selected.push(stores[indexlist[i]])
//		}
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
		store = [[0,1],[1,3],[3,5],[4,5]]
		M = 2
		home [0,1]
		(a,b)(a,c)(a,d)(a,e)
		// store.size개 중 M개 뽑기 - >M개의 치킨집이 있을경우 -> 집과 가까운 치킨집 거리의합
		for (int i = M; i < args.length; i++) {
			
		}
		
		
	}
	
	public static class Cell{
		int x;
		int y;
		
		public Cell() {
			// TODO Auto-generated constructor stub
		}
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void Comb() {
		
	}
	
	public static int getDistance(Cell c1, Cell c2) {
		int d = 0;
		d = Math.abs(c1.x-c2.x) + Math.abs(c1.y-c2.y);
		return d;
	}

}
