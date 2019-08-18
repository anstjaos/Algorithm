#include <iostream>
#include <algorithm>
using namespace std;

int n, arr[10001];
int dp[10001], result = -2123456789;

int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	sort(arr, arr + n, [](const int &a, const int &b) {
		return a > b;
	});

	result = max(result,  (arr[0] * arr[1] * arr[2]));
	result = max(result, (arr[0] * arr[1]));
	result = max(result, arr[n - 1] * arr[n - 2]);
	result = max(result, arr[n - 1] * arr[n - 2] * arr[0]);

	printf("%d\n", result);
	return 0;
}