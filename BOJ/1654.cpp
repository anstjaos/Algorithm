#include <iostream>
using namespace std;

int K, N;
long long arr[10001], minVal = 0, maxVal;

int min(int a, int b) { return (a < b ? a : b); }
long long max(long long a, long long b) { return (a > b ? a : b); }

int solve(int val)
{
	int cnt = 0;

	for (register int i = 0; i < K; i++) {
		cnt += arr[i] / val;
	}

	return cnt;
}

int main()
{
	scanf("%d %d", &K, &N);
	for (int i = 0; i < K; i++) {
		scanf("%lld", arr + i);
	}
	maxVal = LLONG_MAX;
	long long result = 0;
	while (minVal <= maxVal)
	{
		long long mid = (minVal + maxVal) / 2;
		int temp = solve(mid);
		
		if (temp >= N)
		{
			minVal = mid + 1;
			if (mid > result) result = mid;
		}
		else maxVal = mid - 1;
	}

	printf("%lld\n", result);
	return 0;
}