<<<<<<< HEAD
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
=======
#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}point;

int row, col;
int map[1003][1003];
int dp[1003][1003];

int max(int a, int b) { return (a > b ? a : b); }


int main()
{
	
	cin >> row >> col;

	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			cin >> map[i][j];
			dp[i][j] = 0;
		}
	}

	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			int result = max(dp[i - 1][j], dp[i - 1][j - 1]);
			result = max(result, dp[i][j - 1]);
			result += map[i][j];
			dp[i][j] = result;
		}
	}
	
	cout << dp[row][col] << endl;
	return 0;

>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
}