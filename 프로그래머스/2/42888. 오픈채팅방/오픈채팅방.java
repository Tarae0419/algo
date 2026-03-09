import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userInfo = new HashMap<>();
        List<String[]> actions = new ArrayList<>();
        
        for(String str : record){
            String[] strArray = str.split(" ");
            
            String cmd = strArray[0];
            String uid = strArray[1];
            
            if(cmd.equals("Enter") || cmd.equals("Change")) userInfo.put(uid, strArray[2]);
            if(cmd.equals("Enter") || cmd.equals("Leave")) actions.add(new String[]{cmd, uid});
        }
        
        List<String> result = new ArrayList<>();
        for(String[] action : actions){
            String cmd = action[0];
            String uid = action[1];
            
            if(cmd.equals("Enter")) result.add(userInfo.get(uid) + "님이 들어왔습니다.");
            else result.add(userInfo.get(uid) + "님이 나갔습니다.");
        }
        
        return result.toArray(String[]::new);
    }
}