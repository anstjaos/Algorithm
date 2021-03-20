#include <cstdio>

int L, arr[51],N, cnt;

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }

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
	scanf("%d", &L);
	for (register int i = 0; i < L; i++) scanf("%d", arr + i);
	scanf("%d", &N);
	quickSort(0, L - 1);

	int left = 1, right = 0;

	for (register int i = 0; i < L; i++) {
		if (arr[i] >= N) {
			right = arr[i];
			break;
		}
		left = arr[i] + 1;
	}

	for (register int i = left; i < right; i++) {
		for (register int j = i + 1; j < right; j++) {
			if (i <= N && N <= j) {
				cnt++;
			}
		}
	}
	printf("%d\n", cnt);
	return 0;
}