#include <stdio.h>
#define QUEUE_SIZE 100005

typedef struct {
	int x; 
	int y;
}Loc;

int N, arr[105][105];
char map[105][105];
Loc queue[QUEUE_SIZE];
int front, rear, dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
bool visit[105][105];

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

void charBfs(Loc start)
{
	front = rear = -1;
	visit[start.x][start.y] = true;
	char c = map[start.x][start.y];
	push(start);

	while (front != rear)
	{
		Loc cur = pop();
		for (register int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];
			
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			if (map[nextX][nextY] != c || visit[nextX][nextY]) continue;

			visit[nextX][nextY] = true;
			push({ nextX, nextY });
		}
	}
}

void bfs(Loc start)
{
	front = rear = -1;
	visit[start.x][start.y] = true;
	int v = arr[start.x][start.y];
	push(start);

	while (front != rear)
	{
		Loc cur = pop();
		for (register int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			if (arr[nextX][nextY] != v || visit[nextX][nextY]) continue;

			visit[nextX][nextY] = true;
			push({ nextX, nextY });
		}
	}
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++)
	{
		for (register int j = 0; j < N; j++) {
			scanf(" %c", &map[i][j]);

			if (map[i][j] == 'R' || map[i][j] == 'G') arr[i][j] = 1;
			else arr[i][j] = 0;
		}
	}

	int cnt = 0;
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {
			if (!visit[i][j]) {
				charBfs({ i,j });
				cnt++;
			}
		}
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) visit[i][j] = false;
	}

	printf("%d ", cnt);
	cnt = 0;
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {
			if (!visit[i][j]) {
				bfs({ i,j });
				cnt++;
			}
		}
	}
	printf("%d\n", cnt);
	return 0;
}