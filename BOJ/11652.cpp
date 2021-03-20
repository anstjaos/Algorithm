#include <iostream>
using namespace std;

int N;
long long arr[1000001];
long long maxCnt, maxNum, curCnt;
long long before;

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	long long pivot = arr[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex] < pivot) leftIndex++;
		while (arr[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(arr[leftIndex], arr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) cin >> arr[i];
	maxCnt = 0;
	curCnt = 0;
	before = 2123456789;
	quickSort(0, N - 1);

	for (int i = 0; i < N; i++)
	{
		if (i == 0)
		{
			before = arr[i];
			maxNum = arr[i];
			maxCnt = 1;
			curCnt = 1;
			continue;
		}

		if (before != arr[i])
		{
			if (curCnt > maxCnt)
			{
				maxCnt = curCnt;
				curCnt = 1;
				maxNum = before;
			}
			before = arr[i];
		}
		else if (before == arr[i]) curCnt++;
	}

	if (curCnt > maxCnt)
	{
		maxCnt = curCnt;
		curCnt = 1;
		maxNum = before;
	}

	cout << maxNum << '\n';
	return 0;
}