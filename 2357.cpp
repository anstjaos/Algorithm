#include <iostream>
#define INF -1

typedef struct {
	int minNum;
	int maxNum;
}Segment;

int N, M, a, b, height;
Segment arr[400002];

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }

int findMin(int left, int right, int cur, int curL, int curR)
{
	if (right < curL || curR < left) return 2123456789;
	if (left <= curL && curR <= right) return arr[cur].minNum;

	int mid = (curL + curR) / 2;
	return min(findMin(left, right, cur * 2, curL, mid), findMin(left, right, cur * 2 + 1, mid + 1, curR));
}

int findMax(int left, int right, int cur, int curL, int curR)
{
	if (right < curL || curR < left) return INF;
	if (left <= curL && curR <= right) return arr[cur].maxNum;

	int mid = (curL + curR) / 2;
	return max(findMax(left, right, cur * 2, curL, mid), findMax(left, right, cur * 2 + 1, mid + 1, curR));
}

int main()
{
	scanf("%d %d", &N, &M);
	while ((1 << height) < N) height++;

	int temp;
	for (register int i = 0; i < N; i++)
	{
		scanf("%d", &temp);
		arr[(1 << height) + i].maxNum = temp;
		arr[(1 << height) + i].minNum = temp;
	}

	for (register int i = (1 << height) + N; i < 1 << (height + 1); i++)
	{
		arr[i].maxNum = INF;
		arr[i].minNum = INF;
	}

	for (register int i = height - 1; i >= 0; i--)
	{
		for (register int j = 1 << i; j < 1 << (i + 1); j++)
		{
			arr[j].maxNum = max(arr[j * 2].maxNum, arr[j * 2 + 1].maxNum);
			
			if (arr[j * 2].minNum == INF || arr[j * 2 + 1].minNum == INF) arr[j].minNum = max(arr[j * 2].minNum, arr[j * 2 + 1].minNum);
			else arr[j].minNum = min(arr[j * 2].minNum, arr[j * 2 + 1].minNum);
 		}
	}

	for (register int i = 0; i < M; i++)
	{
		scanf("%d %d", &a, &b);
		printf("%d %d\n", findMin(a,b,1,1, 1<<height), findMax(a,b,1,1, 1<<height));
	}
	return 0;
}