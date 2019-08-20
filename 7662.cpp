#include <stdio.h>
#define MAX_SIZE 1000001

int N, tc, visitCnt;
bool visit[1000001];

typedef struct Item{
	int num;
	int idx;
}Item;

typedef struct MaxHeap {
	Item heap[MAX_SIZE];
	int cnt;

	MaxHeap() { cnt = 0; }

	void push(Item item)
	{
		heap[++cnt] = item;
		int idx = cnt;

		while (idx > 1) {
			if (heap[idx / 2].num > heap[idx].num) break;
			
			Item temp = heap[idx / 2];
			heap[idx / 2] = heap[idx];
			heap[idx] = temp;

			idx /= 2;
		}
	}

	Item pop()
	{
		Item ret = heap[1];
		heap[1] = heap[cnt--];

		int parent = 1;
		int child;

		while (1)
		{
			if (parent * 2 > cnt) break;

			if (parent * 2 == cnt) child = parent * 2;
			else {
				if (heap[parent * 2].num > heap[parent * 2 + 1].num) child = parent * 2;
				else child = parent * 2 + 1;
			}

			if (heap[parent].num > heap[child].num) break;

			Item temp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = temp;
			parent = child;
		}
		return ret;
	}

	Item top() { return heap[1]; }

	bool empty() { return cnt == 0; }
}MaxHeap;

typedef struct MinHeap {
	Item heap[MAX_SIZE];
	int cnt;

	MinHeap() { cnt = 0; }

	void push(Item item)
	{
		heap[++cnt] = item;
		int idx = cnt;

		while (idx > 1) {
			if (heap[idx / 2].num < heap[idx].num) break;

			Item temp = heap[idx / 2];
			heap[idx / 2] = heap[idx];
			heap[idx] = temp;

			idx /= 2;
		}
	}

	Item pop()
	{
		Item ret = heap[1];
		heap[1] = heap[cnt--];

		int parent = 1;
		int child;

		while (1)
		{
			if (parent * 2 > cnt) break;

			if (parent * 2 == cnt) child = parent * 2;
			else {
				if (heap[parent * 2].num < heap[parent * 2 + 1].num) child = parent * 2;
				else child = parent * 2 + 1;
			}

			if (heap[parent].num < heap[child].num) break;

			Item temp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = temp;
			parent = child;
		}
		return ret;
	}

	Item top() { return heap[1]; }

	bool empty() { return cnt == 0; }
}MinHeap;

MaxHeap maxHeap;
MinHeap minHeap;

int main(void)
{
	scanf("%d", &tc);
	for (register int t = 0; t < tc; t++)
	{
		scanf("%d", &N);
		visitCnt = 0;
		maxHeap.cnt = 0;
		minHeap.cnt = 0;

		for (register int i = 0; i < N; i++)
		{
			char input;
			int num;

			scanf(" %c %d", &input, &num);

			if (input == 'I')
			{
				maxHeap.push({ num, i });
				minHeap.push({ num, i });
				visit[i] = true;
			}
			else
			{
				if (num == 1)
				{
					while (!maxHeap.empty() && !visit[maxHeap.top().idx]) maxHeap.pop();

					if (!maxHeap.empty())
					{
						visit[maxHeap.top().idx] = false;
						maxHeap.pop();
					}
				}
				else
				{
					while (!minHeap.empty() && !visit[minHeap.top().idx]) minHeap.pop();

					if (!minHeap.empty())
					{
						visit[minHeap.top().idx] = false;
						minHeap.pop();
					}
				}
			}
		}

		while (!maxHeap.empty() && !visit[maxHeap.top().idx]) maxHeap.pop();
		while (!minHeap.empty() && !visit[minHeap.top().idx]) minHeap.pop();


		if (minHeap.empty() && maxHeap.empty()) printf("EMPTY\n");
		else printf("%d %d\n", maxHeap.top().num, minHeap.top().num);

	}

	return 0;

}