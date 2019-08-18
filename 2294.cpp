#include <iostream>
using namespace std;

int n, k, coin[101], dp[100001];

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	cin >> n >> k;
	for (int i = 0; i < n; i++)
	{
		cin >> coin[i];
		dp[coin[i]] = 1;
	}

	for (int i = 1; i <= k; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (i - coin[j] >= 0)
			{
				if (dp[i - coin[j]] == 0) continue;

				if (dp[i] == 0) dp[i] = dp[i - coin[j]] + 1;
				else
				{
					dp[i] = min(dp[i], dp[i - coin[j]] + 1);
				}
			}
		}
	}

	if (dp[k] == 0) cout << "-1" << '\n';
	else cout << dp[k] << '\n';

	return 0;
}