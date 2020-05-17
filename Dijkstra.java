public class Dijkstra {
    public static class Graph {
        private int n;           //노드들의 수
        private int maps[][];    //노드들간의 가중치 저장할 변수

        // 생성자. 노드의 수를 객체 생성시에 정해주고,
        // 배열에서 index 1부터 활용하기 위해서 maps 2차원 배열을 [n+1][n+1]로 생성해준다.
        public Graph(int n) {
            this.n = n;
            maps = new int[n + 1][n + 1];

        }

        // 노드들간의 가중치를 저장해주는 메서드
        public void input(int i, int j, int w) {
            maps[i][j] = w;
            maps[j][i] = w;
        }

        public void dijkstra(int v) {
            int distance[] = new int[n + 1];          //최단 거리를 저장할 변수
            boolean[] check = new boolean[n + 1];     //해당 노드를 방문했는지 체크할 변수

            //distance값 초기화.
            for (int i = 1; i < n + 1; i++) {
                // Integer.MAX_VALUE를 처음에 넣음으로서, 사실상 무한대 숫자를 넣는다.
                distance[i] = Integer.MAX_VALUE;
            }

            // 시작노드값 초기화 및 방문 체크를 true로 저장. (v는 시작 노드값)
            distance[v] = 0;
            check[v] = true;

            //연결노드 distance갱신
            for (int i = 1; i < n + 1; i++) {
                //방문을 아직 하지 않았고, 거리가 0이 아니면
                if (!check[i] && maps[v][i] != 0) {
                    //distance 값에 입력한 가중치를 넣어준다.
                    distance[i] = maps[v][i];
                }
            }


            for (int a = 0; a < n - 1; a++) {
                //원래는 모든 노드가 true될때까지 인데
                //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
                //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
                int min = Integer.MAX_VALUE;
                int min_index = -1;

                //최소 가중치가 되는 곳 찾기 //가장 작은 값과 그 정점 찾기
                for (int i = 1; i < n + 1; i++) {
                    //distance[i]가 Integer.MAX_VALUE가 아니라는 것은 연결되어 있다는 것이다.
                    if (!check[i] && distance[i] != Integer.MAX_VALUE) { // 방문안했고 연결된(컴퓨터에게 지금 보이는) 것 중에서 제일 작은 값 찾기
                        if (distance[i] < min) {
                            min = distance[i];
                            min_index = i;
                        }
                    }
                }

                /* 최소 가중치가 되는 곳을 더 이상 방문하지 않도록 true로 바꿔준다.
                 왜냐하면 음수 가중치는 존재하지 않기 때문에 최소 가중치가 된다는 것은 더 적은 가중치로 이 곳에 도달할 수 없다는 이야기입니다.
                */
                check[min_index] = true;

                for (int i = 1; i < n + 1; i++) {
                    //최소 간선 거리가 되는 곳과 연결되는 곳을 체크한다.
                    if (!check[i] && maps[min_index][i] != 0) { // 아직 처리안됐고 min_index와 연결된 i정점
                        //min_index(최소 간선 거리가 된 정점)까지의 거리 + min_index부터 i까지의 거리가 distance[i]보다 작으면 값을 갱신
                        if (distance[i] > distance[min_index] + maps[min_index][i]) { //min_index를 거쳐서 가는 것이 원래 distance보다 작으면 갱신
                            distance[i] = distance[min_index] + maps[min_index][i];
                        }
                    }
                }

            }

            //결과값 출력
            for (int i = 1; i < n + 1; i++) {
                System.out.print(distance[i] + " ");
            }
            System.out.println("");

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.input(1, 2, 7);
        g.input(1, 3, 10);
        g.input(2, 6, 20);
        g.input(3, 4, 5);
        g.input(3, 5, 15);
        g.input(4, 6, 5);
        g.input(5, 6, 10);
        g.input(6, 7, 5);
        g.dijkstra(1);
    }


}

