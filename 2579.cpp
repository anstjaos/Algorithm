#include <iostream>
using namespace std;

int stair;
int arr[301];
int dp[301];

int max(int a, int b) { return (a > b ? a : b); }
int main()
{
	cin >> stair;
	for (int i = 1; i <= stair; i++)
	{
		cin >> arr[i];
	}
	dp[0] = 0;
	for (int i = 1; i <= 3; i++)
	{
		if (i != 3)
		{
			dp[i] = dp[i - 1] + arr[i];
		}
		else
		{
			dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
		}
	}
	
	for (int i =4; i <= stair; i++)
	{
		dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
	}
	cout << dp[stair] << endl;
	
}