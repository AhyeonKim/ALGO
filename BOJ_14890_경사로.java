import java.util.Scanner;

public class BOJ_14890_경사로 {
	static int N, L;
	static int[][] map;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		int[] line;
		// 가로
		for (int i = 0; i < N; i++) {
			line = new int[N];
			for (int j = 0; j < N; j++) {
				line[j] = map[i][j];
			}
			if(isRoad(line)) {
				ans++;
			}
		}
		
		// 세로
		for (int j = 0; j < N; j++) {
			line = new int[N];
			for (int i = 0; i < N; i++) {
				line[i] = map[i][j];
			}
			if(isRoad(line)) {
				ans++;
			}
		}
//		
//		int[] test = {3,2,2,1,2,3};
//		System.out.println(isRoad(test));
		System.out.println(ans);
	}
	
	public static boolean isRoad(int[] line) {
		boolean flag = true;
		int index = 0;
		int tmp = line[index];
		for (int i = 0; i < L; i++) {
			if(tmp!=line[i]) {
				flag = false;				
			}else {
				index = i;
			}
		}
		while(index<N && flag) {
			if(line[index]==tmp) {
				index++;
				continue;
			}else if(Math.abs(line[index]-tmp)==1) {
				int newtmp = line[index];
				if(index+L-1<N) {
					for (int j = index; j < index+L; j++) {
						if(newtmp==line[j]) {
							newtmp = line[j];
							continue;
						}else {
							flag = false;
							break;
						}
					}
				}else {
					flag = false;
					break;
				}
				if(flag) {
					index = index+L;
					if(index<N) {
						if(line[index]!=newtmp) {
							flag =false;
							break;
						}
					}
					tmp = newtmp;
				}
			}else {
				flag = false;
				break;
			}
		}
		if(flag) {
			for (int i = 0; i < line.length; i++) {
				System.out.print(line[i]+" ");
			}
			System.out.println();
		}
		return flag;
	}
}
