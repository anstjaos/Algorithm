#include <iostream>
using namespace std;

int N, arr[100001];

int max(int a, int b) { return (a > b ? a : b); }
int min(int a, int b) { return (a < b ? a : b); }

int solve(int start, int end)
{
	if (start == end) return 0;
	if (start + 1 == end) return 0;

	int mid = (start + end) / 2;
	int result = max(solve(start, mid), solve(mid, end));

	int left = mid, right = mid, w = 1, h = arr[mid];
	while (right - left + 1 < end - start) {
		int p = left > start ? min(h, arr[left - 1]) : -1;
		int q = right + 1 < end ? min(h, arr[right + 1]) : -1;

		if (p >= q) {
			h = p;
			left--;
		}
		else {
			h = q;
			right++;
		}

		result = max(result, ++w * h);
	}
	return result;
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
	}
	
	printf("%d\n", solve(0, N));
	return 0;
}