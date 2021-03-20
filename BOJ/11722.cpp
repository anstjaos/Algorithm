#include <stdio.h>

int N, arr[1005], dp[1005];

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) scanf("%d", arr + i);
	dp[0] = 1;
	int res = 1;
	for (register int i = 1; i < N; i++) {
		dp[i] = 1;
		for (register int j = i - 1; j >= 0; j--) {
			if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
				dp[i] = dp[j] + 1;
				res = max(res, dp[i]);
			}
		}
	}

	printf("%d\n", res);
	return 0;
}