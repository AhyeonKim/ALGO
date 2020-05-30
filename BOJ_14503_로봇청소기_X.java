import java.util.Scanner;

public class BOJ_14503_로봇청소기_X {
	static int N, M;
	static int[][] map;
	static int ans;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt(); //0:북 1:동 2:남 3:서
		if(d==1) {
			d = 3;
		}else if(d==3) {
			d = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt(); // 빈칸 0, 벽 1, 청소됨 2
			}
		}
		ans = 0;
		if(map[r][c]==0) {
			map[r][c] = 2;
			ans++;
		}
		boolean flag = false;
		
		while(true) {
			flag = false;
			d = (d+1)%4;
			int nr = r+di[d];
			int nc = c+di[d];
			if(map[nr][nc]==0) {
				r = nr;
				c = nc;
				map[r][c] = 2;
				ans++;
			}else {
				for (int x = 0; x < 3; x++) {
					d = (d+1)%4;
					nr = r+di[d];
					nc = c+di[d];
					if(map[nr][nc]==0) {
						r = nr;
						c = nc;
						map[r][c] = 2;
						ans++;
						break;
					}
					if(x==2) {
						flag = true;
					}
				}
			}
			if(!flag) {
				continue;
			}else {
				r = r-di[d];
				c = c-dj[d];
				if(map[r][c] == 1) {
					break;
				}	
			}
		}
		
		System.out.println(ans);
	}
	
}
