#include <iostream>
using namespace std;

int N;
int target, cur;
int arr[250000];
int dp[250000];
int maxNum = -1;

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	cin >> N;
	target = 1;
	cur = 0;

	int size = (N * (N + 1)) / 2;
	for (int i = 1; i <= size; i++) cin >> arr[i];
	dp[1] = arr[1];

	for (int i = 1; i <= size; i++)
	{
		if (cur == target)
		{
			target++;
			cur = 0;
		}
		dp[i + target] = max(dp[i + target], dp[i] + arr[i + target]);
		dp[i + target + 1] = max(dp[i + target + 1], dp[i] + arr[i + target + 1]);
		cur++;
	}

	target = (N* (N - 1)) / 2;
	for (int i = target + 1; i <= size; i++)
	{
		if (dp[i] > maxNum) maxNum = dp[i];
	}
	cout << maxNum << endl;
}