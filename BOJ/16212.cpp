#include <cstdio>

int N, arr[500001], cnt[4000001];
/*
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
*/
int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d", arr + i);
		cnt[arr[i] + 2000000]++;
	}

	for (register int i = 0; i < 4000001; i++) {
		while (cnt[i] > 0) {
			cnt[i]--;
			printf("%d ", i - 2000000);
		}
		
	}
	printf("\n");
	return 0;
}