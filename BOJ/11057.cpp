#include <iostream>
using namespace std;

int dp[1001][10], input;


int main()
{
	cin >> input;

	for (int i = 0; i < 10; i++) dp[1][i] = 1;

	for (int i = 2; i <= input; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			for (int k = 0; k <= j; k++)
			{
				dp[i][j] = (dp[i][j]+ dp[i - 1][k]) % 10007;
			}
		}
	}

	int result = 0;
	for (int i = 0; i < 10; i++) result = (result + dp[input][i]) % 10007;

	cout << result << '\n';
	return 0;
}
