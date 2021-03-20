#include <cstdio>

int tc, n, arr[101], sum;

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
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d", &n);
		for (register int i = 0; i < n; i++) scanf("%d", arr + i);
		sum = 0;
		while (n > 1)
		{
			quickSort(0, n - 1);
			int a = arr[n - 1], b = arr[n - 2];
			sum += (a + b);
			arr[n - 2] = (a + b);
			n--;
		}
		printf("%d\n", sum);
	}
	return 0;
}