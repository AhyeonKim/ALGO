import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class SWEA_3124_최소스패닝트리 {
	static int N, E;
	static ArrayList<Edge> mst;
	static int[] disjoint;
	static PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt(); // 정점개수
			E = sc.nextInt(); // 간선개수
			
			for (int e = 0; e < E; e++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				int value = sc.nextInt();
				
				pq.add(new Edge(v1,v2,value));
			}// 입력받기 완료.
			
			kruskal();
			long ans = 0;
			for (int i = 0; i < mst.size(); i++) {
				ans+=mst.get(i).value;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}// end main
	
	static void kruskal() {
		mst = new ArrayList<>();
		disjoint = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			disjoint[i] = i;
		}
		
		while(mst.size() < (N-1)) {
			Edge edge = pq.poll();
			
			if(find(edge.start)!=find(edge.end)) { //사이클을 이루는지 확인
				union(edge.start,edge.end); //같은 색으로 칠해줌
				mst.add(edge);
			}
		}
	}
	static int find(int n) {
		if(disjoint[n]==n) {
			return n;
		}
		disjoint[n] = find(disjoint[n]); //찾으면서 값을 바꿔줌
		return disjoint[n];
	}
	
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1!=p2) {
			disjoint[p2]=p1; //p2의 root 정보를 p1으로 변경
		}
	}
	static class Edge{
		int start, end, value;
		
		Edge(int s, int e, int v){
			start=s; end=e; value=v;
		}
	}
	
	static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value-o2.value;
		}
	}
}
