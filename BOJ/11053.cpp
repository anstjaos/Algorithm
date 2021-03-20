<<<<<<< HEAD
#include <stdio.h>

int N, arr[1001], dp[1001];

int max(int a, int b) { return (a > b ? a : b); }
int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) scanf("%d", arr + i);
	dp[0] = 1;

	int res = 1;
	for (register int i = 1; i < N; i++) {
		dp[i] = 1;
		for (register int j = i - 1; j >= 0; j--) {
			if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
				dp[i] = dp[j] + 1;
				res = max(res, dp[i]);
			}
		}
	}
	printf("%d\n", res);
=======
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
>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
	return 0;
}