import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3184_양 {
	static int R, C;
	static char[][] field;
	static boolean[][] visit;
	static int vcnt, ocnt;
	static int vtmp, otmp;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		field = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			int j = 0;
			for(char c: str) {
				field[i][j++] = c;
			}
		}
		vcnt = 0;
		ocnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visit[i][j]) {
					vtmp = 0;
					otmp = 0;
					check(i,j);
					if(otmp>vtmp) {
						ocnt += otmp;
					}else {
						vcnt += vtmp;
					}
				}
			}
		}
		System.out.println(ocnt+" "+vcnt);
	}
	private static void check(int i, int j) {
		visit[i][j] = true;
		if(field[i][j]=='v') {
			vtmp++;
		}else if(field[i][j]=='o') {
			otmp++;
		}
		for (int d = 0; d < 4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(!isOut(ni,nj)&&!visit[ni][nj]&&field[ni][nj]!='#') {
				check(ni,nj);
			}
		}
	}
	private static boolean isOut(int ni, int nj) {
		if(ni>=R || nj>=C || ni<0 || nj<0) {
			return true;
		}
		return false;
	}
}