#include <cstdio>

int N, cnt, arr[10], input[10];
bool check[10];

void solve( int cur)
{
	if (cur == cnt)
	{
		for (register int i = 0; i < cnt; i++)
		{
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}

	for (register int i = 1; i <= N; i++)
	{
		if (!check[i])
		{
			check[i] = true;
			arr[cur] = input[i];
			solve(cur + 1);
			check[i] = false;
		}
	}
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = input[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (input[leftIndex] < pivot) {
			if (leftIndex == right) break;
			leftIndex++;
		}
		while (input[rightIndex] > pivot) {
			if (rightIndex == left) break;
			rightIndex--;
		}

		if (leftIndex <= rightIndex)
		{
			int temp = input[leftIndex];
			input[leftIndex] = input[rightIndex];
			input[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	scanf("%d %d", &N, &cnt);
	for (register int i = 1; i <= N; i++) scanf("%d", input + i);
	quickSort(1, N);
	solve(0);
	return 0;
}