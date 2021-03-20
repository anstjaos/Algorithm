#include <stdio.h>
#define INF 2123456789

char input[2600];
int len, dp[2600];
bool palindrom[2600][2600];

int strLen(char *s)
{
	int idx = 0;
	while (s[idx]) idx++;
	return idx;
}

int main()
{
	scanf("%s ", input +1);
	len = strLen(input+1);

	palindrom[1][1] = true;
	for (register int i = 2; i <= len; i++) {
		palindrom[i][i] = true;
		if (input[i - 1] == input[i]) palindrom[i - 1][i] = true;
	}

	for (register int i = 2; i < len; i++) {
		for (register int j = 1; j + i <= len; j++) {
			if (input[j] != input[j + i]) continue;

			if (palindrom[j+1][j+i-1]) palindrom[j][j + i] = true;
		}
	}

	for (register int i = 1; i <= len; i++) {
		for (int j = 1; j <= i; j++) {
			if (palindrom[j][i]) {
				if (dp[i] == 0 || dp[i] > dp[j - 1] + 1) {
					dp[i] = dp[j - 1] + 1;
				}
			}
		}
	}
	printf("%d\n", dp[len]);
	return 0;
}