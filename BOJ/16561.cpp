#include <stdio.h>

int num, result, dp[3001][5];

int dfs(int cnt, int n)
{
	int &ret = dp[n][cnt];
	if (ret != -1) return ret;
	ret = 0;
	if (cnt == 3) {
		if (n == 0) ret++;

		return ret;
	}

	for (register int i = 3; i <= n; i += 3) {
		ret += dfs(cnt + 1, n - i);
	}
	return ret;
}

int main()
{
	scanf("%d", &num);
	for (register int i = 0; i < 3001; i++) {
		for (register int j = 0; j < 5; j++) dp[i][j] = -1;
	}
	result = dfs(0, num);

	printf("%d\n", result);
	return 0;
}