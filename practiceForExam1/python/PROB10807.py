N = int(input())
N_list = list(map(int, input().split()))  # 공백 제거 후 배열에 담는다.
v = int(input())

print(N_list.count(v))
