#include <stdio.h>
#define MAX_COUNT 5000001

typedef struct {
	int left;
	int right;
}Range;

Range stack[MAX_COUNT];
int arr[5000001];
int N, K ,top;

void push(Range r)
{
	stack[++top] = r;
}

Range pop()
{
	top--;
	return stack[top + 1];
}

void quickSort(int left, int right)
{
	top = -1;
	push({ left, right });
	
	while (top != -1) {
		Range cur = pop();
		int leftIndex = cur.left;
		int rightIndex = cur.right;
		int pivot = arr[(leftIndex + rightIndex) / 2];

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

		if (cur.left < rightIndex) push({ cur.left, rightIndex });
		if (leftIndex < cur.right) push({ leftIndex, cur.right });
	}
}

int main()
{
	scanf("%d %d", &N, &K);
	for (int i = 0; i < N; i++) scanf("%d",&arr[i]);
	
	quickSort(0, N - 1);
	printf("%d\n", arr[K - 1]);
	return 0;
}