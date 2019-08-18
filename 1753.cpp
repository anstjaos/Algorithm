#include <iostream>
#include <queue>
#include <functional>
using namespace std;

#define QUEUE_SIZE 300001
typedef struct a{
	int to;
	int weight;
	a* next;

	a() {}
	a(int i_t, int i_w, a* i_n) {
		to = i_t;
		weight = i_w;
		next = i_n;
	}
}edge;

int vertexCnt, edgeCnt, start,from, to, weight;
//int queue[QUEUE_SIZE], front, rear;
priority_queue<int, vector<int>, greater<int>> pq;
edge* ed[20001];
bool inQ[20002];
int cost[20002];
int min(int a, int b) { return (a < b ? a : b); }
//
//void push(int item)
//{
//	rear = (rear + 1) % QUEUE_SIZE;
//	queue[rear] = item;
//}
//
//void pop()
//{
//	front = (front + 1) % QUEUE_SIZE;
//}
//
//int getFront()
//{
//	int temp = (front + 1) % QUEUE_SIZE;
//	return queue[temp];
//}
//
//void quickSort(int left, int right)
//{
//	int leftIndex = left;
//	int rightIndex = right;
//	int pivot = cost[queue[(left + right) / 2]];
//
//	while (leftIndex <= rightIndex)
//	{
//		while (cost[queue[leftIndex]] < pivot) leftIndex++;
//		while (cost[queue[rightIndex]] > pivot) rightIndex--;
//
//		if (leftIndex <= rightIndex)
//		{
//			swap(queue[leftIndex], queue[rightIndex]);
//			leftIndex++;
//			rightIndex--;
//		}
//	}
//
//	if (left < rightIndex) quickSort(left, rightIndex);
//	if (leftIndex < right) quickSort(leftIndex, right);
//}

void dijkstra(int start)
{
	edge* ptr = ed[start];
	while (ptr != NULL)
	{
		if (cost[ptr->to] == 0)
		{
			cost[ptr->to] = ptr->weight;
			pq.push(ptr->to);
			inQ[ptr->to] = true;
		}
		else cost[ptr->to] = min(cost[ptr->to], ptr->weight);

		ptr = ptr->next;
	}
	
	int cur = start;
	while (!pq.empty())
	{
		//quickSort(front + 1, rear);

		cur = pq.top();
		pq.pop();
		inQ[cur] = false;

		ptr = ed[cur];
		while (ptr != NULL)
		{
			if (cost[ptr->to] == 0)
			{
				cost[ptr->to] = cost[cur] + ptr->weight;
				inQ[ptr->to] = true;
				pq.push(ptr->to);
			}
			else
			{
				if (cost[ptr->to] > cost[cur] + ptr->weight)
				{
					cost[ptr->to] = cost[cur] + ptr->weight;
					if (inQ[ptr->to] == false) {
						inQ[ptr->to] = true;
						pq.push(ptr->to);
					}
				}
			}

			ptr = ptr->next;
		}
		
	}
}

int main()
{
	scanf("%d %d %d", &vertexCnt, &edgeCnt, &start);
	for (register int i = 1; i <= vertexCnt; i++) ed[i] = NULL;

	for (int i = 0; i < edgeCnt; i++)
	{
		scanf("%d %d %d", &from, &to, &weight);
		if (ed[from] == NULL) ed[from] = new edge(to, weight, NULL);
		else ed[from] = new edge(to, weight, ed[from]);
	}

	dijkstra(start);
	for (int i = 1; i <= vertexCnt; i++)
	{
		if (i == start)
		{
			printf("0\n");
			continue;
		}

		if (cost[i] == 0)
		{
			printf("INF\n");
		}
		else printf("%d\n", cost[i]);
	}

	for (register int i = 1; i <= vertexCnt; i++) {
		edge* ptr = ed[i];
		edge* prePtr = ed[i];
		while (ptr != NULL)
		{
			prePtr = ptr;
			ptr = ptr->next;
			delete prePtr;
		}
	}
	return 0;
}