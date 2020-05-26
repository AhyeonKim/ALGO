import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_17471_게리맨더링 {
	
	static int N;
	static int[] city;
	static int[][] connect;
	static int min;
	static boolean[] visit;
	static ArrayList<Integer> groupA, groupB;
	static boolean divide;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		city = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		connect = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				connect[i][Integer.parseInt(st.nextToken())-1] = 1;
			}
		}
		min = Integer.MAX_VALUE;
		
		visit = new boolean[N];
		Comb(0,0);
		
		System.out.println(divide?min:-1);
	}
	
	public static void Comb(int target, int cnt) {
		if(target==N-1) {
			groupA = new ArrayList<>();
			groupB = new ArrayList<>();	
			for (int j = 0; j < N; j++) {
				if(visit[j]) {
					groupA.add(j);
				}else {
					groupB.add(j);
				}
			}
			if(groupA.size()>0 && groupB.size()>0) {
				if(isConnect(groupA) && isConnect(groupB)) {
					for (int i = 0; i < groupA.size(); i++) {
						System.out.print(groupA.get(i)+" ");
					}
					System.out.println();
					System.out.println();
					for (int i = 0; i < groupB.size(); i++) {
						System.out.print(groupB.get(i)+" ");
					}
					System.out.println();
					System.out.println("------------------------");
					
					divide = true;
					int tmp = Math.abs(sum(groupA)-sum(groupB));
					if(tmp<min) {
						min = tmp;
					}
				}
			}
		} 
		else {
			visit[target] = true;
			Comb(target+1,cnt+1);
			visit[target] = false;
			Comb(target+1,cnt);
		}
	}
	
	public static boolean isConnect(ArrayList<Integer> group) {
		Set<Integer> tmp = new TreeSet<>();
		boolean flag = true;
		
		for (int i = 0; i < group.size(); i++) {
			for (int j = 0; j < N; j++) {
				if(connect[group.get(i)][j]==1) {
					tmp.add(j);
				}
			}
		}
		if(group.size()>1) {
			for (int i = 0; i < group.size(); i++) {
				if(!tmp.contains(group.get(i))) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	public static int sum(ArrayList<Integer> group) {
		int sum = 0;
		for (int i = 0; i < group.size(); i++) {
			sum += city[group.get(i)];
		}
		return sum;
	}
}