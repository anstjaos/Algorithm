#include <cstdio>

typedef struct {
	int x;
	int y;
}Pt;

int N, dp[25][10], dirX[6] = { -1, -1, 1, 1, 1, -1 }, dirY[6] = { 0, 1, 1, 0, -1, -1 };

int solve(int idx, int dir, Pt cur, Pt start)
{
	if (idx == N) {
		if (cur.x == start.x && cur.y == start.y) return 1;
		return 0;
	}

	int &ret = dp[idx][dir];
	ret = 0;
	int nextD = (dir - 1 + 6) % 6;
	ret += solve(idx + 1, nextD, { cur.x + dirX[nextD], cur.y + dirY[nextD] }, start);
	nextD = (dir + 1) % 6;
	ret += solve(idx + 1, nextD, { cur.x + dirX[nextD], cur.y + dirY[nextD] }, start);

	return ret;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i <= N; i++) {
		for (register int j = 0; j < 10; j++) dp[i][j] = -1;
	}

	int res = 0;
	for (register int i = 0; i < 6; i++) {
		res += solve(0, i, { dirX[i], dirY[i] }, { 0,0 });
	}
	printf("%d\n", res);
	return 0;
}