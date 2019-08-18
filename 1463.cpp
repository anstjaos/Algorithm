#include <stdio.h>
#define INF 2123456789

int dp[100005], N;

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) dp[i] = INF;
	for (register int i = N; i > 1; i--) {
		if (dp[i] == INF) continue;

		if (i % 3 == 0) dp[i / 3] = min(dp[i/3], dp[i] + 1);
		if (i % 2 == 0) dp[i / 2] = min(dp[i / 2], dp[i] + 1);
		dp[i - 1] = min(dp[i - 1], dp[i] + 1);
	}

	printf("%d\n", dp[1]);
	return 0;
}