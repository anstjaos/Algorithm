#include <iostream>
#include <algorithm>
using namespace std;

int arr[200001], n, c;

int main()
{
	scanf("%d %d", &n, &c);
	for (int i = 0; i < n; i++) scanf("%d", arr + i);

	sort(arr, arr + n);

	int left = 1;
	int right = arr[n - 1] - arr[0];
	int d, ans = 0;

	while (left <= right)
	{
		int mid = (left + right) / 2;
		int cnt = 1;
		int start = arr[0];

		for (int i = 1; i < n; i++)
		{
			d = arr[i] - start;
			if (mid <= d)
			{
				cnt++;
				start = arr[i];
			}
		}

		if (cnt >= c)
		{
			ans = mid;
			left = mid + 1;
		}
		else right = mid - 1;
	}

	printf("%d\n", ans);
	return 0;
}