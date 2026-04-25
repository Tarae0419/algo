class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->{
            double len1 = Math.sqrt(Math.pow(o1.x, 2) + Math.pow(o1.y, 2));
            double len2 = Math.sqrt(Math.pow(o2.x, 2) + Math.pow(o2.y, 2));

            return Double.compare(len1, len2);
        });

        for(int[] point : points){
            pq.add(new Node(point[0], point[1]));
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++){
            Node curNode = pq.poll();
            result[i][0] = curNode.x;
            result[i][1] = curNode.y;
        }

        return result;
    }

    public class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}