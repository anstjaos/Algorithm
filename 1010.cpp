#include <iostream>
using namespace std;

int dp[31][31];
int testCase, N, M;

int main()
{
	cin >> testCase;
	for (int i = 0; i < 31; i++) dp[1][i] = i;
	for (int i = 2; i < 31; i++)
	{
		for (int j = i; j < 31; j++)
		{
			for (int k = j; k >= i; k--)
			{
				dp[i][j] += dp[i - 1][k-1];
			}
		}
	}
	for (int i = 0; i < testCase; i++)
	{
		cin >> N >> M;
		cout << dp[N][M] << endl;
	}
	return 0;
}
