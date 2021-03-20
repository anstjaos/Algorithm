#include <stdio.h>

typedef struct {
	int x, y;
}mv;

int map[101][101], bridge[101][101];
bool visit[101][101];
int mapSize, minNum = 2123456789, front, rear;
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };
mv queue[1000001];

int min(int a, int b) { return (a > b ? a : b); }
void push(mv item)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = item;
}

void pop() { front = (front + 1) % 1000001; }

mv getFront()
{
	int temp = (front + 1) % 1000001;
	return queue[temp];
}

void island(int x, int y, int num)
{
	front = rear = -1;
	push({ x,y});

	map[x][y] = num;
	mv cur;
	while (front != rear)
	{
		cur = getFront();
		pop();
		

		for (register int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= mapSize || nextY >= mapSize) continue;

			if (map[nextX][nextY] == 1)
			{
				map[nextX][nextY] = num;
				push({ nextX,nextY});
			}
			
		}
	}
}

void bfs(int num)
{
	front = rear = -1;
	for (register int i = 0; i < mapSize; i++)
	{
		for (register int j = 0; j < mapSize; j++)
		{
			bridge[i][j] = 0;
			visit[i][j] = false;
		}
	}

	for (register int i = 0; i < mapSize; i++)
	{
		for (register int j = 0; j < mapSize; j++)
		{
			if (map[i][j] == num)
			{
				push({ i,j });
			}
		}
	}

	mv cur;
	int nextX, nextY;
	while (front != rear)
	{
		cur = getFront();
		
		pop();

		if (visit[cur.x][cur.y] == true) continue;

		visit[cur.x][cur.y] = true;
		for (register int i = 0; i < 4; i++)
		{
			nextX = cur.x + dirX[i];
			nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= mapSize || nextY >= mapSize) continue;

			if (map[nextX][nextY] != 0 && map[nextX][nextY] != num)
			{
				if (bridge[cur.x][cur.y] < minNum) minNum = bridge[cur.x][cur.y];
			}
			if (map[nextX][nextY] == 0)
			{
				if(bridge[nextX][nextY] != 0 ) bridge[nextX][nextY] = min(bridge[nextX][nextY], bridge[cur.x][cur.y] + 1);
				else bridge[nextX][nextY] = bridge[cur.x][cur.y] + 1;
				push({ nextX,nextY });
			}
		}
	}
}

int main()
{
	scanf("%d", &mapSize);

	for (register int i = 0; i < mapSize; i++)
	{
		for (register int j = 0; j < mapSize; j++) scanf("%d", &map[i][j]);
	}

	int num = 2;
	for (register int i = 0; i < mapSize; i++)
	{
		for (register int j = 0; j < mapSize; j++)
		{
			if (map[i][j] == 1)
			{
				island(i, j, num);
				num++;
			}
		}
	}

	for (register int i = 2; i < num; i++) bfs(i);

	printf("%d\n", minNum);
	return 0;
}