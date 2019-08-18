#include <iostream>
using namespace std;

int arr[1001], dp[1001], N;

int max(int a, int b) { return (a > b ? a : b); }
int main()
{
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
		dp[i] = arr[i];
	}

	for (int i = 1; i < N; i++)
	{
		for (int j = 0; j < i; j++)
		{
			if (arr[j] < arr[i])
			{
				dp[i] = max(dp[i], dp[j] + arr[i]);
			}
		}
	}

	int result = -1;
	for (int i = 0; i < N; i++)
	{
		if (dp[i] > result) result = dp[i];
	}

	cout << result << '\n';
	return 0;
}
