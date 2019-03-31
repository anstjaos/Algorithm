#include <iostream>
using namespace std;

int testCase;
int K, arr[501], dp[501][501], sum[501];

int min(int a, int b) { return (a < b ? a : b); }
void init()
{
	cin >> K;
	for (int i = 1; i <= K; i++)
	{
		sum[i] = 0;
		for (int j = 1; j <= K; j++) dp[i][j] = 0;
	}
	for (int i = 1; i <= K; i++)
	{
		cin >> arr[i];
		sum[i] = sum[i - 1] + arr[i];
	}

	
}

int main()
{
	cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		init();

		for (int i = 1; i < K; i++)
		{
			for (int j = 1; j + i <= K; j++)
			{
				int to = j + i;
				dp[j][to] = INT_MAX;

				for (int k = j; k < to; k++)
				{
					dp[j][to] = min(dp[j][to], dp[j][k] + dp[k + 1][to] + sum[to] - sum[j - 1]);
				}
			}
		}
		cout << dp[1][K] << '\n';
		
	}
	return 0;
}