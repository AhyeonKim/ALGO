public class Dijkstra {
    public static class Graph {
        private int n;           //������ ��
        private int maps[][];    //���鰣�� ����ġ ������ ����

        // ������. ����� ���� ��ü �����ÿ� �����ְ�,
        // �迭���� index 1���� Ȱ���ϱ� ���ؼ� maps 2���� �迭�� [n+1][n+1]�� �������ش�.
        public Graph(int n) {
            this.n = n;
            maps = new int[n + 1][n + 1];

        }

        // ���鰣�� ����ġ�� �������ִ� �޼���
        public void input(int i, int j, int w) {
            maps[i][j] = w;
            maps[j][i] = w;
        }

        public void dijkstra(int v) {
            int distance[] = new int[n + 1];          //�ִ� �Ÿ��� ������ ����
            boolean[] check = new boolean[n + 1];     //�ش� ��带 �湮�ߴ��� üũ�� ����

            //distance�� �ʱ�ȭ.
            for (int i = 1; i < n + 1; i++) {
                // Integer.MAX_VALUE�� ó���� �������μ�, ��ǻ� ���Ѵ� ���ڸ� �ִ´�.
                distance[i] = Integer.MAX_VALUE;
            }

            // ���۳�尪 �ʱ�ȭ �� �湮 üũ�� true�� ����. (v�� ���� ��尪)
            distance[v] = 0;
            check[v] = true;

            //������ distance����
            for (int i = 1; i < n + 1; i++) {
                //�湮�� ���� ���� �ʾҰ�, �Ÿ��� 0�� �ƴϸ�
                if (!check[i] && maps[v][i] != 0) {
                    //distance ���� �Է��� ����ġ�� �־��ش�.
                    distance[i] = maps[v][i];
                }
            }


            for (int a = 0; a < n - 1; a++) {
                //������ ��� ��尡 true�ɶ����� �ε�
                //��尡 n�� ���� �� ���ͽ�Ʈ�� ���ؼ� �ݺ����� n-1���̸� �ȴ�.
                //������ ������ ������ ��尡 ��� true���� Ȯ���ϴ� ������ �����ص� �ȴ�.
                int min = Integer.MAX_VALUE;
                int min_index = -1;

                //�ּ� ����ġ�� �Ǵ� �� ã�� //���� ���� ���� �� ���� ã��
                for (int i = 1; i < n + 1; i++) {
                    //distance[i]�� Integer.MAX_VALUE�� �ƴ϶�� ���� ����Ǿ� �ִٴ� ���̴�.
                    if (!check[i] && distance[i] != Integer.MAX_VALUE) { // �湮���߰� �����(��ǻ�Ϳ��� ���� ���̴�) �� �߿��� ���� ���� �� ã��
                        if (distance[i] < min) {
                            min = distance[i];
                            min_index = i;
                        }
                    }
                }

                /* �ּ� ����ġ�� �Ǵ� ���� �� �̻� �湮���� �ʵ��� true�� �ٲ��ش�.
                 �ֳ��ϸ� ���� ����ġ�� �������� �ʱ� ������ �ּ� ����ġ�� �ȴٴ� ���� �� ���� ����ġ�� �� ���� ������ �� ���ٴ� �̾߱��Դϴ�.
                */
                check[min_index] = true;

                for (int i = 1; i < n + 1; i++) {
                    //�ּ� ���� �Ÿ��� �Ǵ� ���� ����Ǵ� ���� üũ�Ѵ�.
                    if (!check[i] && maps[min_index][i] != 0) { // ���� ó���ȵư� min_index�� ����� i����
                        //min_index(�ּ� ���� �Ÿ��� �� ����)������ �Ÿ� + min_index���� i������ �Ÿ��� distance[i]���� ������ ���� ����
                        if (distance[i] > distance[min_index] + maps[min_index][i]) { //min_index�� ���ļ� ���� ���� ���� distance���� ������ ����
                            distance[i] = distance[min_index] + maps[min_index][i];
                        }
                    }
                }

            }

            //����� ���
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

