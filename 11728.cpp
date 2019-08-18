#include <iostream>
using namespace std;

int size1, size2;
int arr[2000002];

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
			int temp = arr[rightIndex];
			arr[rightIndex] = arr[leftIndex];
			arr[leftIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

int main()
{
	scanf("%d %d", &size1, &size2);
	for (int i = 0; i < size1; i++)
	{
		scanf("%d", &arr[i]);
	}
	
	for (int j = size1; j < size1 + size2; j++)
	{
		scanf("%d", &arr[j]);
	}

	quickSort(0, size1 + size2 - 1);

	for (int i = 0; i < size1 + size2; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
	return 0;
}