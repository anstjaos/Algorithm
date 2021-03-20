#include <iostream>
using namespace std;

int N, arr[100001],dp[100001];
int maxNum = -2123456789;

int max(int a, int b) { return (a > b ? a : b); }
int main()
{
	cin >> N;
	for (int i = 0; i < N; i++) cin >> arr[i];

	dp[0] = arr[0];

	for (int i = 1; i < N; i++)
	{
		dp[i] = max(arr[i], arr[i] + dp[i - 1]);
	}

	for (int i = 0; i < N; i++)
	{
		if (dp[i] > maxNum) maxNum = dp[i];
	}
	cout << maxNum << endl;
	return 0;
}