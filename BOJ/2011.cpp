#include <stdio.h>

#define MOD 1000000
#define MAX_SIZE 5001

char input[MAX_SIZE];
int dp[MAX_SIZE];

int main()
{
	scanf("%s", input);
	dp[0] = dp[1] = 1;
	int len = 0;
	while (input[len] != '\0') len++;

	for (register int i = 2; i <= len; i++) {
		if (input[i - 1] > '0') {
			dp[i] = dp[i - 1] % MOD;
		}

		int num = (input[i - 2] - '0') * 10 + (input[i - 1] - '0');
		if (10 <= num && num <= 26) {
			dp[i] = (dp[i] + dp[i - 2]) % MOD;
		}
	}

	input[0] == '0' ? printf("0\n") : printf("%d\n", dp[len]);
	return 0;
}