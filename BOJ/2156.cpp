#include <iostream>
using namespace std;

int glass;
int arr[10001];
int dp[10001];
int result;

int max(int a, int b)
{
	return a > b ? a : b;
}

int main()
{
	cin >> glass;
	for (int i = 1; i <= glass; i++) cin >> arr[i];

	for (int i = 1; i < 3 && i <= glass; i++)
	{
		if (i == 1) dp[i] = arr[i];
		else
		{
			dp[i] = arr[i] + arr[i - 1];
		}
	}

	for (int i = 3; i <= glass; i++)
	{
		result = 0;
		result = max(dp[i - 1], arr[i] + arr[i - 1] + dp[i - 3]);
		result = max(result, arr[i] + dp[i - 2]);
		dp[i] = result;
	}

	cout << dp[glass] << endl;
	return 0;
}