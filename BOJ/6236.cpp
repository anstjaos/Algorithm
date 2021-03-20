#include <iostream>
using namespace std;

int N, M, arr[100001], maxVal;

int max(int a, int b) { return (a > b ? a : b); }

int solve(int val)
{
	int cnt = 1;
	int account = val;
	for (int i = 0; i < N; i++) {
		if (account - arr[i] >= 0) {
			account = account - arr[i];
		}
		else {
			cnt++;
			account = val - arr[i];
		}
	}

	return cnt;
}

int main()
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
		maxVal = max(maxVal, arr[i]);
	}

	int left = maxVal;
	int right = 2123456789;

	while (left <= right)
	{
		int mid = (left + right) / 2;

		int temp = solve(mid);
		if (temp > M) {
			left = mid + 1;
		}
		else right = mid - 1;
	}

	printf("%d\n", left);
	return 0;
}