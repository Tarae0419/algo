import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;

        for(String s : operations){
            String[] c = s.split(" ");
            String op = c[0];
            int num = Integer.parseInt(c[1]);   

            if(op.equals("I")){
                map.merge(num, 1, Integer::sum);
                size++;
            }else{
                if(size == 0) continue;

                int key = op.equals("D") && num == 1 ? map.lastKey() : map.firstKey();
                int cnt = map.get(key);
                if(cnt == 1) map.remove(key);
                else map.put(key, cnt - 1);
                size--;
            }
        }

        if(size == 0) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}