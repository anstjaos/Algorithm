#include <stdio.h>
#define MAX_SIZE 100005
#define INF 2123456789

typedef struct {
	int x;
	int y;
}Location;
int row, col, map[105][105], cost[105][105];
Location queue[MAX_SIZE];
int front, rear;
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };

void push(Location item)
{
	rear = (rear + 1) % MAX_SIZE;
	queue[rear] = item;
}

Location pop()
{
	front = (front + 1) % MAX_SIZE;
	return queue[front];
}

void bfs()
{
	front = rear = -1;
	cost[0][0] = 1;
	push({ 0,0 });

	while (front != rear)
	{
		Location cur = pop();

		for (register int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if (map[nextX][nextY] == 0) continue;

			if (cost[nextX][nextY] > cost[cur.x][cur.y] + 1) {
				cost[nextX][nextY] = cost[cur.x][cur.y] + 1;
				push({ nextX, nextY });
			}
		}
	}
}

int main()
{
	scanf("%d %d", &row, &col);
	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			scanf("%1d", &map[i][j]);
			cost[i][j] = INF;
		}
	}

	bfs();
	printf("%d\n", cost[row - 1][col - 1]);
	return 0;
}