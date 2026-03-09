def solution(record):
    user_info = {}
    action = []
    
    for r in record:
        info = r.split()
        cmd, user_id = info[0], info[1]
        
        if cmd in ("Enter", "Change"):
            user_info[user_id] = info[2]
            
        if cmd in ("Enter", "Leave"):
            action.append((cmd, user_id))
    
    result = []
    for cmd, user_id in action:
        if cmd == "Enter":
            result.append(f"{user_info[user_id]}님이 들어왔습니다.")
        else:
            result.append(f"{user_info[user_id]}님이 나갔습니다.")
                          
    return result