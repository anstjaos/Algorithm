#include <iostream>
using namespace std;

int n, m;
long long arr[100001], dp[100001];
long long result = -1;

long long max(long long a, long long b) { return (a > b ? a : b); }

int main()
{
	cin >> n >> m;
	for (int i = 0; i < n; i++) cin >> arr[i];
	dp[0] = arr[0];

	for (int i = 1; i < m; i++)
	{
		dp[i] = dp[i - 1] + arr[i];
		result = max(result, dp[i]);
	}
	for (int i = m; i < n; i++)
	{
		dp[i] = dp[i - 1] - arr[i - m] + arr[i];
		result = max(result, dp[i]);
	}

	cout << result << "\n";
	return 0;
}