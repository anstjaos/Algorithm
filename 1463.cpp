<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
#include <stdio.h>
#define INF 2123456789

int dp[100005], N;

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) dp[i] = INF;
	for (register int i = N; i > 1; i--) {
		if (dp[i] == INF) continue;

		if (i % 3 == 0) dp[i / 3] = min(dp[i/3], dp[i] + 1);
		if (i % 2 == 0) dp[i / 2] = min(dp[i / 2], dp[i] + 1);
		dp[i - 1] = min(dp[i - 1], dp[i] + 1);
	}

	printf("%d\n", dp[1]);
<<<<<<< HEAD
=======
=======
#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000001];

int findNum(int n)
{
	if (n == 1) return 0;
	if (arr[n] != -1) return arr[n];

	int result = findNum(n - 1) + 1;

	if (n % 3 == 0) result = min(result, findNum(n /3) + 1);
	if (n % 2 == 0) result = min(result, findNum(n / 2) + 1);
	arr[n] = result;
	return result;
}

int main()
{
	memset(arr, -1,1000001*sizeof(int));
	int num;
	cin >> num;
	cout << findNum(num) << endl;
>>>>>>> e21cae41e4257f52e57b37172fa0e045b8bfb134
>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
	return 0;
}