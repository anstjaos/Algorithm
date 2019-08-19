#include <stdio.h>

int N, arr[2002], dp[2002][2002], M, S, E;

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d", arr + i);
		dp[i][i] = 1;
	}
	for (register int i = 1; i < N; i++) {
		if (arr[i] == arr[i - 1]) {
			dp[i - 1][i] = 1;
		}
	}
	for (register int i = 2; i < N; i++) {
		for (register int j = 0; i + j < N; j++) {
			if (arr[j] != arr[j + i]) continue;
			dp[j][j + i] = dp[j + 1][j + i - 1];
		}
	}

	scanf("%d", &M);
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &S, &E);
		printf("%d\n", dp[S - 1][E - 1]);
	}

	return 0;
}