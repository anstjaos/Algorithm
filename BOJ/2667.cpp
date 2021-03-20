#include <stdio.h>
#define	QUEUE_SIZE 1000

typedef struct {
	int x;
	int y;
}Loc;

int N, arr[30][30], dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
Loc queue[QUEUE_SIZE];
int front, rear, check[30];
bool visit[30][30];

void push(Loc item)
{
	queue[++rear] = item;
}

Loc pop()
{
	return queue[++front];
}

int bfs(Loc start)
{
	front = rear = -1;
	int ret = 0;
	visit[start.x][start.y] = true;
	push(start);
	
	while (front != rear)
	{
		Loc cur = pop();
		ret++;

		for (register int i = 0; i < 4; i++) {
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			if (arr[nextX][nextY] == 0 || visit[nextX][nextY]) continue;

			visit[nextX][nextY] = true;
			push({ nextX, nextY });
		}
	}

	return ret;
}

void quickSort(int *a, const int left, const int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = a[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (a[leftIndex] < pivot) {
			if (leftIndex == right) break;
			leftIndex++;
		}
		while (a[rightIndex] > pivot) {
			if (rightIndex == left) break;
			rightIndex--;
		}

		if (leftIndex <= rightIndex)
		{
			int temp = a[leftIndex];
			a[leftIndex] = a[rightIndex];
			a[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(a, leftIndex, right);
	if (left < rightIndex) quickSort(a, left, rightIndex);
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%1d", &arr[i][j]);
	}

	int cnt = 0;
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {
			if (!visit[i][j] && arr[i][j] == 1) {
				check[cnt] = bfs({ i,j });
				cnt++;
			}
		}
	}

	quickSort(check, 0, cnt - 1);
	printf("%d\n", cnt);
	for (register int i = 0; i < cnt; i++) printf("%d\n", check[i]);
	return 0;
}