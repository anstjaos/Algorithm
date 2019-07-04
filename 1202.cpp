#include <stdio.h>
#define MAX_COUNT 300001

typedef struct Jewelry {
	int weight;
	int value;
}Jewelry;

typedef struct MaxHeap {
	Jewelry maxHeap[MAX_COUNT];
	int count;

	MaxHeap() {
		count = 0;
	}

	void adjustToTop(int idx)
	{
		while (1)
		{
			if (idx == 1) break;

			if (maxHeap[idx / 2].value < maxHeap[idx].value) {
				Jewelry temp = maxHeap[idx / 2];
				maxHeap[idx / 2] = maxHeap[idx];
				maxHeap[idx] = temp;
				idx = idx / 2;
			}
			else break;
		}
	}

	void adjustToBottom(int idx)
	{
		while(1)
		{
			if (idx * 2 > count && idx * 2 + 1 > count) break;

			if (idx * 2 <= count && idx * 2 + 1 <= count) {
				if (maxHeap[idx * 2].value > maxHeap[idx * 2 + 1].value) {
					if (maxHeap[idx].value < maxHeap[idx * 2].value) {
						Jewelry temp = maxHeap[idx * 2];
						maxHeap[idx * 2] = maxHeap[idx];
						maxHeap[idx] = temp;
						idx = idx * 2;
					}
					else break;
				}
				else {
					if (maxHeap[idx].value < maxHeap[idx * 2 + 1].value) {
						Jewelry temp = maxHeap[idx * 2+1];
						maxHeap[idx * 2+1] = maxHeap[idx];
						maxHeap[idx] = temp;
						idx = idx * 2 + 1;
					}
					else break;
				}
			}
			else {
				if (maxHeap[idx * 2].value > maxHeap[idx].value) {
					Jewelry temp = maxHeap[idx * 2];
					maxHeap[idx * 2] = maxHeap[idx];
					maxHeap[idx] = temp;
				}
				break;
			}
		}
	}

	void push(Jewelry j)
	{
		maxHeap[++count] = j;
		adjustToTop(count);
	}

	Jewelry pop()
	{
		Jewelry ret = maxHeap[1];
		maxHeap[1] = maxHeap[count--];
		adjustToBottom(1);
		return ret;
	}

	void popIdx(int idx)
	{
		maxHeap[idx] = maxHeap[count--];
		adjustToBottom(idx);
		adjustToTop(idx);
	}
}MaxHeap;

int N, K, bag[MAX_COUNT], result;
MaxHeap maxH;

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = bag[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (bag[leftIndex] < pivot) leftIndex++;
		while (bag[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			int temp = bag[leftIndex];
			bag[leftIndex] = bag[rightIndex];
			bag[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	scanf("%d %d", &N, &K);
	for (register int i = 0; i < N; i++) {
		Jewelry temp = { 0,0 };
		scanf("%d %d", &temp.weight, &temp.value);
		maxH.push(temp);
	}

	for (register int i = 0; i < K; i++) {
		scanf("%d", &bag[i]);
	}
	quickSort(0, K - 1);

	for (register int i = 0; i < K; i++) {
		int cnt = maxH.count;
		for (register int j = 1; j < cnt; j++) {
			if (maxH.maxHeap[j].weight <= bag[i]) {
				result += maxH.maxHeap[j].value;
				maxH.popIdx(j);
				break;
			}
		}
	}

	printf("%d\n", result);
	return 0;
}