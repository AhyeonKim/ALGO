import java.util.Scanner;

public class BOJ_15649_N과M2 {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		int[] selected = new int[M];
		comb(selected,0,0);
		
	}
	private static void comb(int[] selected, int cnt, int target) {
		if(cnt==M) {
			for (int i = 0; i < selected.length; i++) {
				System.out.print(arr[selected[i]]+1+" ");
			}
			System.out.println();
			return;
		}else if(target==arr.length) {
			return;
		}
		
		selected[cnt] = target;
		comb(selected,cnt+1,target+1);
		comb(selected,cnt,target+1);
	}

}
