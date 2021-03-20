#include <stdio.h>
#define QUEUE_SIZE 1000005

typedef struct {
	int x;
	int y;
}Loc;

int row, col, arr[1005][1005];
Loc queue[QUEUE_SIZE];
int front, rear;
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
bool flag;

void push(Loc item)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = item;
}

Loc pop()
{
	front = (front + 1) % QUEUE_SIZE;
	return queue[front];
}

int bfs()
{
	int day = 0;
	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			if(arr[i][j] == 1) push({ i,j });
		}
	}

	if (front == rear) return 0;
	while (front != rear)
	{
		flag = true;
		int size = (rear - front + QUEUE_SIZE) % QUEUE_SIZE;
		day++;
		for (register int i = 0; i < size; i++) {
			Loc cur = pop();
			
			for (register int j = 0; j < 4; j++) {
				int nextX = cur.x + dirX[j];
				int nextY = cur.y + dirY[j];

				if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
				if (arr[nextX][nextY] != 0) continue;

				arr[nextX][nextY] = 1;
				push({ nextX, nextY });
			}
		}

		for (register int i = 0; i < row; i++) {
			for (register int j = 0; j < col; j++) {
				if (arr[i][j] == 0) {
					flag = false;
					break;
				}
			}
			if (!flag) break;
		}

		if (flag) break;
	}
	return day;
}

int main()
{
	scanf("%d %d", &col, &row);
	int zeroCnt = 0;
	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 0) zeroCnt++;
		}
	}

	if (zeroCnt == 0) {
		printf("0\n");
		return 0;
	}
	int res = bfs();
	if (!flag) res = -1;
	printf("%d\n", res);
	return 0;
}