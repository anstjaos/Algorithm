#include <cstdio>
#define MAX_SIZE 100001

typedef struct {
	int y;
	int x;
}Point;

Point queue[MAX_SIZE];
int front, rear, N, r, c, farm[100][100];
int dirY[4] = { -1,-1,1,1 }, dirX[4] = { -1,1,1,-1 };

void push(Point item)
{
	rear = (rear + 1) % MAX_SIZE;
	queue[rear] = item;
}

Point pop()
{
	front = (front + 1) % MAX_SIZE;
	return queue[front];
}

void bfs()
{
	front = rear = -1;
	push({ r,c });

	while (front != rear)
	{
		Point cur = pop();
		for (register int i = 0; i < 4; i++)
		{
			int nextY = cur.y + dirY[i];
			int nextX = cur.x + dirX[i];

			if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N || farm[nextY][nextX] == 'v') continue;
			farm[nextY][nextX] = 'v';
			push({ nextY,nextX });
		}
	}
}

int main()
{
	scanf("%d %d %d", &N, &r, &c);
	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) farm[i][j] = '.';
	}
	farm[r][c] = 'v';

	bfs();

	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) printf("%c", farm[i][j]);
		printf("\n");
	}
	return 0;
}