N = int(input())
ans = N
for i in range(N) :
    word = input()
    for j in range(len(word) - 1) :
        if word[j] == word[j + 1] :
            continue
        elif word[j] in word[j + 1:] :
            ans -= 1
            break
print(ans)