#include <stdio.h>
#define MAX_SIZE 10001

bool map[MAX_SIZE][MAX_SIZE], check[MAX_SIZE], res[MAX_SIZE];
int dp[MAX_SIZE][MAX_SIZE], weight[MAX_SIZE], N, maxVal;

int solve(int cur, int cnt)
{
	if (dp[cur][cnt] != -1) return dp[cur][cnt];
}

int main()
{
	scanf("%d", &N);
	for (register int i = 1; i <= N; i++) scanf("%d", &weight[i]);
	int a, b;
	while (scanf("%d", &a) != 0) {
		scanf("%d", &b);
		map[a][b] = map[b][a] = true;
	}

	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) dp[i][j] = -1;
	}

	for (register int i = 1; i <= N; i++) {
		solve(i, 0);
	}

	printf("%d\n", maxVal);
	for (register int i = 1; i <= N; i++) {
		if (res[i]) printf("%d ", i);
	}

	printf("\n");
	return 0;
}