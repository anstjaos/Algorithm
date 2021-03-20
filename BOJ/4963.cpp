#include <stdio.h>

typedef struct {
	int x;
	int y;
}Loc;

int row, col, map[100][100];
Loc queue[100005];
int front, rear;
int dirX[8] = { -1,-1,0,1,1,1,0,-1}, dirY[8] = { 0,1,1,1,0,-1,-1,-1};

void push(Loc item)
{
	queue[++rear] = item;
}

Loc pop()
{
	return queue[++front];
}

void bfs(Loc start)
{
	front = rear = -1;
	map[start.x][start.y] = 0;
	push(start);

	while (front != rear)
	{
		Loc cur = pop();
		for (register int i = 0; i < 8; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if (map[nextX][nextY] == 0) continue;

			map[nextX][nextY] = 0;
			push({ nextX, nextY });
		}
	}
}

int main()
{
	while (1)
	{
		scanf("%d %d", &col, &row);
		if (row == 0 && col == 0) break;

		for (register int i = 0; i < row; i++) {
			for (register int j = 0; j < col; j++) scanf("%d", &map[i][j]);
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