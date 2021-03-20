#include <iostream>
using namespace std;

int result[31], dp[31], N;

int main()
{
	dp[0] = 1;
	result[0] = 1;
	dp[2] = 3;

	for (int i = 4; i <= 30; i += 2) dp[i] = 2;

	for (int i = 2; i <= 30; i += 2)
	{
		for (int j = 2; j <= i; j += 2)
		{
			result[i] += dp[j] * result[i - j];
		}
	}

	cin >> N;
	cout << result[N] << '\n';
	return 0;
}