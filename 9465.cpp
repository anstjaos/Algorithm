#include <iostream>
using namespace std;

int dp[2][200001], n;
int arr[2][200001], testCase;;

int max(int a, int b) { return (a > b ? a : b); }
int main()
{
	cin >> testCase;
	for (int k = 0; k < testCase; k++)
	{
		cin >> n;
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j <  n; j++) cin >> arr[i][j];
		}

		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		dp[0][1] = dp[1][0] + arr[0][1];
		dp[1][1] = dp[0][0] + arr[1][1];

		for (int i = 2; i < n; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (j == 0)
				{
					dp[j][i] = max(dp[1][i - 1], max(dp[0][i - 2], dp[1][i - 2])) + arr[j][i];
				}
				else
				{
					dp[j][i] = max(dp[0][i - 1], max(dp[0][i - 2], dp[1][i - 2])) + arr[j][i];
				}
			}
		}

		cout << max(dp[0][n - 1], dp[1][n - 1]) << '\n';
	}
	
	return 0;
}