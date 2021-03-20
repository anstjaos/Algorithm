#include <iostream>
using namespace std;

long long dp[101][10];
int cnt;

int main()
{
	cin >> cnt;
	dp[1][0] = 0;

	for (int i = 1; i < 10; i++) dp[1][i] = 1;

	for (int i = 2; i <= cnt; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			if (j == 0) dp[i][j] = dp[i - 1][j + 1] % 1000000000;
			else if (j == 9) dp[i][j] = dp[i - 1][j - 1] % 1000000000;
			else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
		}
	}

	long long result = 0;

	for (int i = 1; i < 10; i++)
	{
		result = (result+ dp[cnt][i])% 1000000000;
	}
	cout << result % 1000000000 << endl;
	return 0;
}