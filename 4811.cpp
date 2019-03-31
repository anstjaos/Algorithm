#include <iostream>
using namespace std;

long long dp[31][31];
int num;

void init()
{
	dp[1][1] = 1;
	
	for (int i = 2; i < 31; i++)
	{
		for()
	}
}

int main()
{
	for (int i = 0; i < 31; i++)
	{
		for (int j = 0; j < 31; j++) dp[i][j] = -1;
	}
	while (1)
	{
		cin >> num;
		if (num == 0) break;

		cout << solve(num - 1, 1) << '\n';
	}
	return 0;
}