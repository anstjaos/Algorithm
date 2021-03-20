#include <iostream>
using namespace std;

int cnt;
int arr[201];
int dp[201];
int result = 0;

int main()
{
	cin >> cnt;

	for (int i = 0; i < cnt; i++) cin >> arr[i];

	dp[0] = 1;
	for (int i = 1; i < cnt; i++)
	{
		dp[i] = 1;
		for (int j = 0; j < i; j++)
		{
			if (arr[i] > arr[j] && dp[i] < dp[j] + 1)
			{
				dp[i] = dp[j] + 1;
			}
		}
	}

	for (int i = 1; i < cnt; i++)
	{
		if (dp[i] > result) result = dp[i];
	}

	cout << cnt -result << endl;
	return 0;
}