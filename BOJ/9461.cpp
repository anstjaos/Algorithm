#include <iostream>
using namespace std;

int testCase, target;
long long dp[101];

void init()
{
	dp[1] = dp[2] = dp[3] = 1;
	dp[4] = dp[5] = 2;

	int cnt = 1;
	for (int i = 6; i <= 100; i++)
	{
		dp[i] = dp[cnt] + dp[i - 1];
		cnt++;
	}
}

int main()
{
	cin >> testCase;
	init();
	for (int i = 0; i < testCase; i++)
	{
		cin >> target;
		cout << dp[target] << '\n';
	}

	return 0;
}