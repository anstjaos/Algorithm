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

}