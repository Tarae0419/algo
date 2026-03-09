import re

def solution(files):
    def natural_key(string_):
        parts = re.split(r'(\d+)', string_)
        
        head = parts[0].lower()
        number = int(parts[1])
        
        return (head, number)
    
    return sorted(files, key=natural_key)