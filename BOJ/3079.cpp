#include <iostream>
using namespace std;

int N, arr[100001];
long long M, max;

int main()
{
	cin >> N >> M;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
		if (arr[i] > max) max = arr[i];
	}

	long long left = 1, right = max * M;
	long long result = max * M;
	while (left <= right)
	{
		long long mid = (left + right) / 2;
		long long total = 0;
		for (int i = 0; i < N; i++)
		{
			total = total + (mid / arr[i]);
		}

		if (total < M) left = mid + 1;
		else
		{
			if (result > mid) result = mid;

			right = mid - 1;
		}
	}

	cout << result << endl;
	return 0;
}