#include <iostream>
using namespace std;

int A, B, arrA[200001], arrB[200001], sum;

void quickSort(int left, int right, int *arr)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = arr[(left + right) / 2];

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

	if (leftIndex < right) quickSort(leftIndex, right, arr);
	if (left < rightIndex) quickSort(left, rightIndex, arr);
}

bool binarySearch(int num, int* arr, int size)
{
	int left = 0;
	int right = size - 1;

	while (left <= right)
	{
		int mid = (left + right) / 2;

		if (arr[mid] < num) {
			left = mid + 1;
		}
		else if (arr[mid] == num) return true;
		else {
			right = mid - 1;
		}
	}

	return false;
}

int main()
{
	scanf("%d %d", &A, &B);

	for (register int i = 0; i < A; i++) scanf("%d", arrA + i);
	for (register int i = 0; i < B; i++) scanf("%d", arrB + i);
	quickSort(0, A-1, arrA);
	quickSort(0, B - 1, arrB);

	for (register int i = 0; i < A; i++)
	{
		if(!binarySearch(arrA[i], arrB, B)) sum++;
	}

	for (register int i = 0; i < B; i++) {
		if (!binarySearch(arrB[i], arrA, A)) sum++;
	}

	printf("%d\n", sum);
	return 0;
}