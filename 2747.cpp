#include <iostream>
using namespace std;

int dp[46];

int main()
{
	dp[0] = 0;
	dp[1] = 1;

	for (int i = 2; i < 46; i++)
	{
		dp[i] = dp[i - 1] + dp[i - 2];
	}
	int num;

	cin >> num;

	cout << dp[num] << endl;
	return 0;
}