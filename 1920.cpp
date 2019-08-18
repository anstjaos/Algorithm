#include <iostream>
using namespace std;

int arr[100001];
int N, M;
int num;

void quickSort(int left, int right)
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

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

bool binarySearch(int target, int left, int right)
{
	while (left <= right)
	{
		int mid = (left + right) / 2;
		int pivot = arr[mid];
		if (target > pivot) left = mid + 1;
		else if (target == pivot) return true;
		else
		{
			right = mid - 1;
		}
	}
	return false;
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &arr[i]);
	}

	quickSort(0, N - 1);

	scanf("%d", &M);
	for (int i = 0; i < M; i++)
	{
		scanf("%d", &num);
		if (num < arr[0])printf("0\n");
		else if (num > arr[N - 1]) printf("0\n");
		else printf("%d\n", binarySearch(num, 0, N - 1)); 
	}
}