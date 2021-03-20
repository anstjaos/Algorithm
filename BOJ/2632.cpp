#include <stdio.h>
#define MAX_SIZE 1000

int size, m, n, mInput[MAX_SIZE], nInput[MAX_SIZE];
int mArr[MAX_SIZE*MAX_SIZE+1], nArr[MAX_SIZE*MAX_SIZE+1];
int mArrCnt, nArrCnt;

void quickSort(int *arr, const int left, const int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = arr[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex] < pivot) {
			if (leftIndex == right)break;
			leftIndex++;
		}
		while (arr[rightIndex] > pivot) {
			if (rightIndex == left) break;
			rightIndex--;
		}

		if (leftIndex <= rightIndex)
		{
			int temp = arr[leftIndex];
			arr[leftIndex] = arr[rightIndex];
			arr[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(arr, leftIndex, right);
	if (left < rightIndex) quickSort(arr, left, rightIndex);
}

int lower_bound(int *arr, int left, int right, int target)
{
	while (left < right)
	{
		int mid = (left + right) / 2;

		if (arr[mid] < target) {
			left = mid + 1;
		}
		else right = mid;
	}

	return right;
}

int upper_bound(int *arr, int left, int right, int target)
{
	while (left < right)
	{
		int mid = (left + right) / 2;

		if (arr[mid] <= target) {
			left = mid + 1;
		}
		else right = mid;
	}

	return right;
}

int main()
{
	scanf("%d %d %d", &size, &m, &n);
	for (register int i = 0; i < m; i++) {
		scanf("%d", &mInput[i]);
	}

	for (register int i = 0; i < n; i++) {
		scanf("%d", &nInput[i]);
	}
	mArr[mArrCnt++] = 0;
	nArr[nArrCnt++] = 0;
	int low = 0, high = 0, sum = 0;
	while (low < m)
	{
		sum += mInput[high++];

		if (sum <= size) mArr[mArrCnt++] = sum;
		else
		{
			low++;
			high = low;
			sum = 0;
		}

		if (high == m) high = 0;

		if ((!low && !high) || high + 1 == low)
		{
			low++;
			high = low;
			sum = 0;
		}
	}

	low = 0, high = 0, sum = 0;
	while (low < n)
	{
		sum += nInput[high++];

		if (sum <= size) nArr[nArrCnt++] = sum;
		else
		{
			low++;
			high = low;
			sum = 0;
		}

		if (high == n) high = 0;

		if ((!low && !high) || high + 1 == low)
		{
			low++;
			high = low;
			sum = 0;
		}
	}

	quickSort(mArr, 0, mArrCnt - 1);
	quickSort(nArr, 0, nArrCnt - 1);

	long long res = 0;
	for (register int i = 0; i < mArrCnt; i++)
	{
		int lower = lower_bound(nArr, 0, nArrCnt, size - mArr[i]);
		int upper = upper_bound(nArr, 0, nArrCnt, size - mArr[i]);
		
		res += upper - lower;
	}

	printf("%lld\n", res);
	return 0;
}