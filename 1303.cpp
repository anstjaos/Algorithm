#include <stdio.h>
#define QUEUE_SIZE 10005

typedef struct {
	int y;
	int x;
}Point;

Point queue[QUEUE_SIZE];
int row, col, front, rear, wCnt, bCnt;
int dirY[4] = { -1,0,1,0 }, dirX[4] = { 0,1,0,-1 };
char map[101][101];
bool visit[101][101];

void push(Point p)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = p;
}

Point pop()
{
	front = (front + 1) % QUEUE_SIZE;
	return queue[front];
}

void bfs(Point pt)
{
	visit[pt.y][pt.x] = true;
	front = rear = -1;
	push(pt);

	int ret = 1;
	char c = map[pt.y][pt.x];

	while (front != rear)
	{
		Point cur = pop();

		for (register int i = 0; i < 4; i++) {
			int nextY = cur.y + dirY[i];
			int nextX = cur.x + dirX[i];

			if (nextY < 0 || nextX < 0 || nextY >= row || nextX >= col || visit[nextY][nextX] || map[nextY][nextX] != c) continue;

			ret++;
			visit[nextY][nextX] = true;
			push({ nextY,nextX });
		}
	}

	if (c == 'W') wCnt += ret * ret;
	else bCnt += ret * ret;
}

int main()
{
	scanf("%d %d", &col, &row);
	for (register int i = 0; i < row; i++) scanf("%s", map + i);
	
	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			if (!visit[i][j]) bfs({ i, j });
		}
	}
	
	printf("%d %d\n", wCnt, bCnt);
}