# 1006번 습격자 초라기
# https://www.acmicpc.net/problem/1006

'''
인접 여부 판단 :

if x // N == y // N:    같은 라인(원)에 있을때
    if (x+1) % N == y % N or (x-1) % N == y % N:    # 양 옆
        ...
else:
    if x % N == y % N:  # 위 / 아래
        ...

1구역부터 순회하며 특수부대를 파견 체크
1. 두 구역을 커버할 수 없는 경우 => 한 칸만 담당
2. 두 구역을 커버할 수 있는 경우 => 두 칸 담당, 하지만 여러가지의 경우도 생각해야함
----------------------------------------------------------------
첫 풀이 : 재귀호출.. 버리자
두번째 풀이 : DP

상태로 생각하기 -> 이전 상태, 현재 상

제어해야 할 변수(인덱스) : 2 행, N 열
배열 요소의 의미 : 배치된 팀의 개수(최솟값)

1. 구역에 소대가 배치되었는가 안 되었는가 : 배치 모양
    x o x o
    x x o o

    1-1. o 모양을 만드는 것이 최종 목표
         o
    1-2. 이전 상태 : x o x      현재 상태 : o
                   x x o               o
    1-3. 4xN 배열

2. 경우의 수 구하기 (i번째 열을 o o 로 만들기)
    2-1.
         i-2 i-1  i       i-2 i-1  i
          o   x   x    =>  o   -   -    + 2 소대
          o   x   x        o   -   -
         i-2 i-1  i       i-2 i-1  i
          o   x   x    =>  o   |   |    + 2 소대
          o   x   x        o   |   |
         i-2 i-1  i       i-2 i-1  i
          o   x   x    =>  o   .   .    + 4 소대
          o   x   x        o   .   .
    2-2.
         i-1  i         i-1  i
          o   x     =>   o   |          + 2 소대
          x   x          .   |
         i-1  i         i-1  i
          o   x     =>   o   .          + 2 소대
          x   x          -   -
         i-1  i         i-1  i
          o   x     =>   o   .          + 3 소대
          x   x          .   .
대충 이런 로직으로 풀다가... 다른 사람 풀이 참조
'''

# 원형이기 때문에 처음과 끝 인덱스의 경우에 따라 따로 구해준다.
def dynamic_programing(n):
    # 초기값 설정을 쉽게 하기 위해 배열 크기를 N+1로 하는 방법도 있다.
    dp = [[INF for _ in range(N+1)] for _ in range(4)]
    dp[n][-1] = 0

    for i in range(N):
        # 모든 경우 체크, 비트 연산을 활용하여 코드 줄이기
        for j in range(4):
            dp[0][i] = min(dp[0][i], dp[j][i-1] + int(j & 1 == 0) + int(j & 2 == 0))
        # 00
        if enemy1[i] + enemy2[i] <= W:
            dp[0][i] = min(dp[0][i], dp[0][i-1] + 1)
        # 10
        if enemy1[i + 1] + enemy1[i] <= W:
            dp[1][i] = min(dp[0][i-1] + 2, dp[2][i-1] + 1)
        # 01
        if enemy2[i + 1] + enemy2[i] <= W:
            dp[2][i] = min(dp[0][i-1] + 2, dp[1][i-1] + 1)
        # 11
        if enemy1[i + 1] + enemy1[i] <= W and enemy2[i + 1] + enemy2[i] <= W:
            dp[3][i] = dp[0][i-1] + 2

    return dp


import sys
input = sys.stdin.readline

INF = float('inf')

for _ in range(int(input().rstrip())):
    N, W = map(int, input().rstrip().split())
    enemy1 = list(map(int, input().rstrip().split())) + [0]
    enemy2 = list(map(int, input().rstrip().split())) + [0]

    # 00
    ans = dynamic_programing(0)[0][N-1]

    # 10
    if enemy1[0] + enemy1[N-1] <= W:
        dp = dynamic_programing(1)
        ans = min(ans, dp[2][N-2] + 1, dp[0][N-2] + 2)
    # 01
    if enemy2[0] + enemy2[N-1] <= W:
        dp = dynamic_programing(2)
        ans = min(ans, dp[1][N-2] + 1, dp[0][N-2] + 2)
    # 11
    if enemy1[0] + enemy1[N-1] <= W and enemy2[0] + enemy2[N-1] <= W:
        dp = dynamic_programing(3)
        ans = min(ans, dp[0][N-2] + 2)

    print(ans)
