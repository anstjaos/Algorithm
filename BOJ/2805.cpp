#include <iostream>
using namespace std;

int cnt;
long long M, tree[1000001], result = 0, maxNum = -1, total;

int main()
{
	cin >> cnt >> M;
	for (int i = 0; i < cnt; i++)
	{
		cin >> tree[i];
		if (tree[i] > maxNum) maxNum = tree[i];
	}

	int left = 0;
	long long right = maxNum;

	while (left <= right)
	{
		long long mid = (left + right) / 2;
		total = 0;
		for (int i = 0; i < cnt; i++)
		{
			if (mid < tree[i]) total = total + tree[i] - mid;
			
		}

		if (total >= M)
		{
			if (result < mid) result = mid;

			left = mid + 1;
		}
		else right = mid - 1;
	}
	cout << result << endl;
	return 0;
}