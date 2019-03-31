#include <iostream>
using namespace std;

int dp[10000001][10];
int N, result, cur, start;

int solve1()
{
	int temp = start;
	for (int i = 0; i < cur-1; i++) temp *= 10;
	temp += N - 1;
	return temp;
}

int solve()
{
	if (cur <= 2) return solve1();

	int temp = start;
	for (int i = 0; i < cur-1; i++) temp *= 10;
	
	for (int i = 1; i < start; i++)
	{
		if (N - dp[cur - 1][i] <= 0)
		{
			cur--;
			start = i;
			temp += solve();
			return temp;
		}
		else N -= dp[cur - 1][i];
	}


}

int main()
{
	cin >> N;
	
	if (N < 10)
	{
		cout << N << endl;
		return 0;
	}

	N -= 9;
	for (int i = 0; i < 10; i++)
	{
		dp[1][i] = 1;
		dp[2][i] = i;
		if (N - i <= 0)
		{
			cur = 2;
			start = i;
			cout << solve1() << endl;
			return 0;
		}
		else N -= i;
	}
	
	for (int i = 3; i < 10000001; i++)
	{
		for (int j = 1; j < 10; j++)
		{
			dp[i][j] = 0;
			for (int k = j - 1; k > 0; k--)
			{
				dp[i][j] += dp[i - 1][k];
			}
			if (N - dp[i][j] <= 0)
			{
				cur = i;
				start = j;
				cout << solve() << endl;
				return 0;
			}
			else N -= dp[i][j];
		}
	}
	
}