from functools import cmp_to_key

def solution(numbers):
    def compare(a, b):
        if a + b > b + a:
            return -1
        elif a + b < b + a:
            return 1
        else:
            return 0
    
    str_numbers = list(map(str, numbers))
    
    str_numbers.sort(key=cmp_to_key(compare))
    
    answer = ''.join(str_numbers)
    
    return str(int(answer))