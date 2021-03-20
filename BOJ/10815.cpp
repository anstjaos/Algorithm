#include <iostream>
using namespace std;

int N, M, arr[500002];

bool binarySearch(int left, int right, int target)
{
	while (left <= right)
	{
		int mid = (left + right) / 2;

		if (arr[mid] < target) left = mid + 1;
		else if (arr[mid] > target) right = mid - 1;
		else return true;
	}

	return false;
}

void solve()
{
	int temp;
	scanf("%d ", &M);
	for (int i = 0; i < M; i++)
	{
		scanf("%d ", &temp);
		if (binarySearch(0, N - 1, temp) == true) printf("1 ");
		else printf("0 ");
	}
	printf("\n");
}

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

int main()
{
	scanf("%d ", &N);

	for (int i = 0; i < N; i++) scanf("%d ", &arr[i]);
	
	quickSort(0, N-1);
	solve();
	return 0;
}