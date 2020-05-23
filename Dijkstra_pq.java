import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_pq {
	static int N, E; // 정점수, 간선수
	static int[][] graph; // 인접 행렬
	static int[] distance; // 각 정점까지의 거리 기록 배열
	static boolean[] visit;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		E = sc.nextInt();
		
		graph = new int[N+1][N+1];
		distance = new int[N+1];
		visit = new boolean[N+1];
		pq = new PriorityQueue<>();
		
		for (int e = 0; e < E; e++) {
			graph[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		dijkstra(1);
		
		System.out.println(Arrays.toString(distance));
	}
	static void dijkstra(int start) {
		// 1. 전체 정점까지의 거리는 일단 무한대로 설정해놓기
		for (int i = 1; i <= N; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		// 2. 시작 정점을 pq에 넣고 반복문 진입시키기
		distance[start] = 0;
		pq.add(new Edge(start,start,0));
		// 3. 반복문에서 가장 짧은 간선을 빼서 (처음엔 시작정점에서 시작정점으로 가는 거리 0짜리가 나옴) 해당 간선의 정점 방문처리.
		//	이때 방문처리란 모든 정점까지 갈 때 지금 선택한 정점을 찍고 가는게 빠른지 안찍고 가는게 빠른지 보는 것!
		while(!pq.isEmpty()) {
			Edge min = pq.poll(); // 지금 확보된 간선중 가장 길이가 짧은 간선을 뽑는다.
			visit[min.end] = true; // 해당 간선 끝에 있는 정점을 방문처리한다.
			
			for (int i = 1; i <= N; i++) { // 다른 모든 정점들에 대해 지금 뽑은 min.end 정점을 찍고 가는게 빠른지 보자.
				if(graph[min.end][i]>0 && distance[i]>distance[min.end]+graph[min.end][i]) {
					distance[i] = distance[min.end]+graph[min.end][i];
					// 4. 3번에서 선택한 정점에서 나가는 간선들도 추가로 pq에 넣기.
					pq.add(new Edge(min.end,i,graph[min.end][i]));
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int start, end, value; // 간선의 시작, 끝 정점번호 및 가중치
		
		public Edge(int s, int e, int v) {
			start = s;
			end = e;
			value = v;
		}
		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
		
	}
}

/*
6 10
1 2 3
1 3 4
3 2 1
2 4 5
3 4 4
3 5 5
4 5 3
5 1 3
4 6 4
5 6 5
 */
