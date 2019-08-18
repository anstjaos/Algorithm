#include <stdio.h>

int N, dp[100005];
int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i <= N; i++) dp[i] = i;
	for (register int i = 2; i <= N; i++) {
		for (register int j = 2; j*j <= i; j++) {
			dp[i] = min(dp[i], dp[i - j * j] + 1);
		}
	}

	printf("%d\n", dp[N]);
	return 0; 
}