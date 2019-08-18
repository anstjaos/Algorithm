#include <iostream>
using namespace std;

int M, N, map[501][501], dp[501][501];
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0, 1, 0, -1 };

int dfs(int r, int c)
{
	if (r == N-1 && c == M-1) return 1;
	if (dp[r][c] != -1) return dp[r][c];

	dp[r][c] = 0;
	for (register int i = 0; i < 4; i++) {
		int nextX = r + dirX[i];
		int nextY = c + dirY[i];
		
		if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
		if (map[nextX][nextY] < map[r][c]) {
			dp[r][c] += dfs(nextX, nextY);
		}
	}
	return dp[r][c];
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < M; j++) {
			scanf("%d", &map[i][j]);
			dp[i][j] = -1;
		}
	}

	int result = dfs(0, 0);
	printf("%d\n", result);
	return 0;
}