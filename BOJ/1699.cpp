#include <stdio.h>

int N, dp[100005];
<<<<<<< HEAD

=======
>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &N);
<<<<<<< HEAD
	for (register int i = 1; i <= N; i++) dp[i] = i;
=======
	for (register int i = 0; i <= N; i++) dp[i] = i;
>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
	for (register int i = 2; i <= N; i++) {
		for (register int j = 2; j*j <= i; j++) {
			dp[i] = min(dp[i], dp[i - j * j] + 1);
		}
	}

	printf("%d\n", dp[N]);
<<<<<<< HEAD
	return 0;
=======
	return 0; 
>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
}