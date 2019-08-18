#include <iostream>
using namespace std;

int N, arr[100001];

long long max(long long a, long long b) { return (a > b ? a : b); }
long long min(long long a, long long b) { return (a < b ? a : b); }

long long solve(int start, int end)
{
	if (start == end) return (long long)arr[start] * arr[start];
	if (start == end - 1) return (long long)arr[start] * arr[start];

	int mid = (start + end) / 2;
	long long result = max(solve(start, mid), solve(mid, end));

	int left = mid, right = mid;
	long long sum = arr[mid], minVal = arr[mid];
	while (right - left + 1 < end - start) {
		int p = left > start ? min(minVal, arr[left - 1]) : -1;
		int q = right < end - 1 ? min(minVal, arr[right + 1]) : -1;

		if (p >= q)
		{
			minVal = p;
			left--;
			sum = sum + arr[left];
		}
		else
		{
			minVal = q;
			right++;
			sum = sum + arr[right];
		}

		result = max(result, sum * minVal);
	}

	return result;
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
	}

	printf("%lld\n", solve(0, N));
	return 0;
}