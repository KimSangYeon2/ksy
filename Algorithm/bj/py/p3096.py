def hanoi(N, s, e) :
    if(N == 1) : 
        print(s, e)
        return
    hanoi(N - 1, s, 6 - (s + e))
    print(s, e)
    hanoi(N - 1, 6 - (s + e), e)
    
N = int(input())
print(2 ** N - 1)
hanoi(N, 1, 3)