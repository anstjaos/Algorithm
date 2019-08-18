#include <iostream>
using namespace std;
int cnt;
int arr[1001];
int dp[1001];
int maxNum = -1;
int main()
{
	cin >> cnt;
	for (int i = 0; i < cnt; i++) cin >> arr[i];
	dp[0] = 1;

	for (int i = 1; i < cnt; i++)
	{
		dp[i] = 1;
		for (int j = i - 1; j >= 0; j--)
		{
			if (arr[i] > arr[j] && dp[i] < dp[j]+1)
			{
				dp[i] = dp[j] + 1;
			}
		}
	}

	for (int i = 0; i < cnt; i++)
	{
		if (dp[i] > maxNum) maxNum = dp[i];
	}
	cout << maxNum << endl;
	return 0;
}