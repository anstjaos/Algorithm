#include <stdio.h>

int row, col, arr[1005][1005], dp[1005][1005];

int max(int a, int b) { return (a > b ? a : b); }
int main()
{
	scanf("%d %d", &row, &col);
	for (register int i = 1; i <= row; i++) {
		for (register int j = 1; j <= col; j++) {
			scanf("%d", &arr[i][j]);
			dp[i][j] = arr[i][j];

			int maxVal = max(dp[i - 1][j], max(dp[i][j - 1], dp[i - 1][j - 1]));
			dp[i][j] += maxVal;
		}
	}

	printf("%d\n", dp[row][col]);
	return 0;
}