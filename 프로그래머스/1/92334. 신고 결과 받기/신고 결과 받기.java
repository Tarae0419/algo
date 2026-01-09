import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reported = new HashMap<>();
        Map<String, Integer> mailCount = new HashMap<>();
        
        for (String id : id_list) {
            mailCount.put(id, 0);
        }       
        
        for(String rep : report){
            String[] reps = rep.split(" ");
            String reporter = reps[0];
            String target = reps[1];
            
            if (!reported.containsKey(target)) {
                reported.put(target, new HashSet<>());
            }
            reported.get(target).add(reporter);
        }
        
        for (String target : reported.keySet()) {
            Set<String> reporters = reported.get(target);
            
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }
        
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            result[i] = mailCount.get(id_list[i]);
        }

        return result;
    }
}