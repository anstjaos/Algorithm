#include <stdio.h>
#define MAX_COUNT 100001

typedef struct a{
	int minHeap[MAX_COUNT];
	int count;

	a() {
		count = 0;
	}

	void adjustToBottom(int idx)
	{
		while (1)
		{
			if (idx * 2 > count && idx * 2 + 1 > count) break;

			if (idx * 2 <= count && idx * 2 + 1 <= count)
			{
				if (minHeap[idx * 2] < minHeap[idx * 2 + 1]) {
					if (minHeap[idx] > minHeap[idx * 2]) {
						int temp = minHeap[idx];
						minHeap[idx] = minHeap[idx * 2];
						minHeap[idx * 2] = temp;
						idx = idx * 2;
					}
					else break;
				}
				else {
					if (minHeap[idx] > minHeap[idx * 2 + 1]) {
						int temp = minHeap[idx];
						minHeap[idx] = minHeap[idx * 2 + 1];
						minHeap[idx * 2 + 1] = temp;
						idx = idx * 2 + 1;
					}
					else break;
				}
			}
			else if (idx * 2 <= count) {
				if (minHeap[idx] > minHeap[idx * 2]) {
					int temp = minHeap[idx];
					minHeap[idx] = minHeap[idx * 2];
					minHeap[idx * 2] = temp;
				}
				break;
			}
		}
	}

	void adjustToTop(int idx)
	{
		while (1)
		{
			if (idx == 1) break;

			if (minHeap[idx / 2] > minHeap[idx]) {
				int temp = minHeap[idx / 2];
				minHeap[idx / 2] = minHeap[idx];
				minHeap[idx] = temp;
				idx = idx / 2;
			}
			else break;
		}
	}

	void push(int num)
	{
		minHeap[++count] = num;
		adjustToTop(count);
	}

	int pop()
	{
		if (count < 1) return -1;
		int ret = minHeap[1];
		minHeap[1] = minHeap[count--];
		adjustToBottom(1);

		return ret;
	}
	
	void deleteNum(int num)
	{
		int idx = 0;
		for (register int i = 1; i <= count; i++) {
			if (minHeap[i] == num) {
				idx = i;
				break;
			}
		}

		if (idx == count) {
			count--;
			return;
		}
		minHeap[idx] = minHeap[count--];
		adjustToBottom(idx);
		adjustToTop(idx);
	}
}MinHeap;

typedef struct b{
	int maxHeap[MAX_COUNT];
	int count;

	b() {
		count = 0;
	}
	void adjustToBottom(int idx)
	{
		while (1)
		{
			if (idx * 2 > count && idx * 2 + 1 > count) break;

			if (idx * 2 <= count && idx * 2 + 1 <= count)
			{
				if (maxHeap[idx * 2] > maxHeap[idx * 2 + 1]) {
					if (maxHeap[idx] < maxHeap[idx * 2]) {
						int temp = maxHeap[idx];
						maxHeap[idx] = maxHeap[idx * 2];
						maxHeap[idx * 2] = temp;
						idx = idx * 2;
					}
					else break;
				}
				else {
					if (maxHeap[idx] < maxHeap[idx * 2 + 1]) {
						int temp = maxHeap[idx];
						maxHeap[idx] = maxHeap[idx * 2 + 1];
						maxHeap[idx * 2 + 1] = temp;
						idx = idx * 2 + 1;
					}
					else break;
				}
			}
			else if (idx * 2 <= count) {
				if (maxHeap[idx] < maxHeap[idx * 2]) {
					int temp = maxHeap[idx];
					maxHeap[idx] = maxHeap[idx * 2];
					maxHeap[idx * 2] = temp;
				}
				break;
			}
		}
	}

	void adjustToTop(int idx)
	{
		while (1)
		{
			if (idx == 1) break;

			if (maxHeap[idx / 2] < maxHeap[idx]) {
				int temp = maxHeap[idx / 2];
				maxHeap[idx / 2] = maxHeap[idx];
				maxHeap[idx] = temp;
				idx = idx / 2;
			}
			else break;
		}
	}

	void push(int num)
	{
		maxHeap[++count] = num;
		adjustToTop(count);
	}

	int pop()
	{
		if (count < 1) return -1;
		int ret = maxHeap[1];
		maxHeap[1] = maxHeap[count--];
		adjustToBottom(1);

		return ret;
	}

	void deleteNum(int num)
	{
		int idx = 0;
		for (register int i = 1; i <= count; i++) {
			if (maxHeap[i] == num) {
				idx = i;
				break;
			}
		}

		if (idx == count) {
			count--;
			return;
		}
		maxHeap[idx] = maxHeap[count--];
		adjustToBottom(idx);
		adjustToTop(idx);
	}
}MaxHeap;

int N, result;

int main()
{
	scanf("%d", &N);
	int temp = 0;
	
	MinHeap minH;
	//MaxHeap maxH;
	for (register int i = 0; i < N; i++)
	{
		scanf("%d", &temp);
		minH.push(temp);
		//maxH.push(temp);
	}

	while (minH.count != 1) {
		int minVal = minH.pop();
		//int maxVal = maxH.pop();
		int minVal2 = minH.pop();

		result += minVal + minVal2;
		//minH.deleteNum(maxVal);
		//maxH.deleteNum(minVal);

		minH.push(minVal + minVal2);
		//maxH.push(minVal + maxVal);
	}

	printf("%d\n", result);
	return 0;
}