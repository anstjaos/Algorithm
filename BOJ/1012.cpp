#include <stdio.h>
#define MAX_SIZE 3000

typedef struct {
	int x;
	int y;
}Loc;

int row, col, k, map[100][100];
Loc queue[MAX_SIZE];
int front, rear;
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };

void push(Loc item)
{
	rear = (rear + 1) % MAX_SIZE;
	queue[rear] = item;
}

Loc pop()
{
	front = (front + 1) % MAX_SIZE;
	return queue[front];
}

void bfs(Loc start)
{
	front = rear = -1;
	map[start.x][start.y] = 0;
	push(start);

	while (front != rear)
	{
		Loc cur = pop();
		for (register int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col)continue;
			if (map[nextX][nextY] == 0) continue;

			map[nextX][nextY] = 0;
			push({ nextX, nextY });
		}
	}
}

int main()
{
	int tc;
	scanf("%d", &tc);
	for (register int t = 0; t < tc; t++)
	{
		scanf("%d %d %d", &row, &col, &k);
		int a, b;
		for (register int i = 0; i < k; i++)
		{
			scanf("%d %d", &a, &b);
			map[a][b] = 1;
		}

		int cnt = 0;
		for (register int i = 0; i < row; i++) {
			for (register int j = 0; j < col; j++) {
				if (map[i][j] == 1) {
					bfs({ i,j });
					cnt++;
				}
			}
		}

		printf("%d\n", cnt);
	}
	return 0;
}