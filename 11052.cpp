#include <iostream>
using namespace std;

int dp[1001];
int arr[1001];
int N;

int max(int a, int b)
{
	return (a > b ? a : b);
}
int main()
{
	cin >> N;
	for (int i = 1; i <= N; i++) cin >> arr[i];
	dp[0] = 0;

	for (int i = 1; i <= N; i++)
	{
		dp[i] = 0;
		for (int j = 1; j <= i; j++)
		{
			dp[i] = max(dp[i], dp[i - j] + arr[j]);
		}
	}
	cout << dp[N] << endl;
}