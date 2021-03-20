#include <cstdio>

int N, arr[2250003];

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = arr[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex] > pivot) leftIndex++;
		while (arr[rightIndex] < pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			int temp = arr[leftIndex];
			arr[leftIndex] = arr[rightIndex];
			arr[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N*N; i++) scanf("%d", arr + i);

	quickSort(0, N*N);
	printf("%d\n", arr[N - 1]);
	return 0;
}