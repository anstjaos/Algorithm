#include <stdio.h>

int N, arr[130][130];
long long dp[130][130];

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%d", &arr[i][j]);
	}

	if (arr[0][0] == 0) {
		printf("0\n");
		return 0;
	}
	dp[0][0] = 1;
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {
			if (dp[i][j] == 0 || arr[i][j] == 0) continue;
			dp[i + arr[i][j]][j] += dp[i][j];
			dp[i][j + arr[i][j]] += dp[i][j];
		}
	}

	printf("%lld\n", dp[N - 1][N - 1]);
	return 0;
}