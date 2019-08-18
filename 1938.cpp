#include <iostream>
using namespace std;

// 0, false : 수평 , 1, true : 수직
typedef struct {
	int x, y;
	int dir;
}inform;

inform start, dest, queue[1000001];
int moveX[4] = { -1,0,1,0 }, moveY[4] = { 0,1,0,-1 }, front, rear, mapSize;
int rotateX[8] = { -1,-1,0,1,1,1,0,-1 }, rotateY[8] = { 0,1,1,1,0,-1,-1,-1 };
char map[52][52];
int check[51][51][2];

void push(inform item)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 1000001;
}

inform getFront()
{
	int temp = (front + 1) % 1000001;
	return queue[temp];
}

void init()
{
	bool flag = false;
	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++)
		{
			if (map[i][j] == 'B')
			{
				if (map[i][j + 1] == 'B')
				{
					start.x = i;
					start.y = j + 1;
					start.dir = 0;
				}
				else if (map[i + 1][j] == 'B')
				{
					start.x = i + 1;
					start.y = j;
					start.dir = 1;
				}
				flag = true;
				break;
			}
			
		}
		if (flag == true) break;
	}

	flag = false;
	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++)
		{
			if (map[i][j] == 'E')
			{
				if (map[i][j + 1] == 'E')
				{
					dest.x = i;
					dest.y = j + 1;
					dest.dir = 0;
				}
				else if (map[i + 1][j] == 'E')
				{
					dest.x = i + 1;
					dest.y = j;
					dest.dir = 1;
				}
				flag = true;
				break;
			}
			
		}
		if (flag == true) break;
	}
}

void bfs()
{
	front = rear = -1;
	push(start);
	inform cur;

	while (front != rear)
	{
		bool flag = true;
		cur = getFront();
		pop();

		if (cur.x == dest.x && cur.y == dest.y && cur.dir == dest.dir) return;

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + moveX[i];
			int nextY = cur.y + moveY[i];

			if (nextX < 0 || nextY < 0 || nextX >= mapSize || nextY >= mapSize) continue;
			if (check[nextX][nextY][cur.dir] != 0) continue;

			if (cur.dir == 0) // 수평
			{
				if (i % 2 == 1) // 좌, 우
				{
					if (nextY == 0 || nextY == mapSize - 1) continue;
				}				
			}
			else if (cur.dir == 1) // 수직
			{
				if (i % 2 == 0) // 상, 하
				{
					if (nextX == 0 || nextX == mapSize - 1) continue;
				}
			}

			if (cur.dir == 0)
			{
				if (map[nextX][nextY] == '1' || map[nextX][nextY - 1] == '1' || map[nextX][nextY + 1] == '1') continue;
			}
			else if (cur.dir == 1)
			{
				if (map[nextX][nextY] == '1' || map[nextX + 1][nextY] == '1' || map[nextX - 1][nextY] == '1') continue;
			}

			check[nextX][nextY][cur.dir] = check[cur.x][cur.y][cur.dir] + 1;
			push({ nextX,nextY,cur.dir });
		}

		for (int i = 0; i < 8; i++)
		{
			int nextX = cur.x + rotateX[i];
			int nextY = cur.y + rotateY[i];

			if (nextX < 0 || nextY < 0 || nextX >= mapSize || nextY >= mapSize)
			{
				flag = false;
				break;
			}
			if (map[nextX][nextY] == '1')
			{
				flag = false;
				break;
			}
		}

		if (flag == true && check[cur.x][cur.y][(cur.dir+1)%2] == 0)
		{
			check[cur.x][cur.y][(cur.dir + 1) % 2] = check[cur.x][cur.y][cur.dir] + 1;
			push({ cur.x,cur.y, (cur.dir + 1) % 2 });
		}
	}
}

int main()
{
	cin >> mapSize;
	for (int i = 0; i < mapSize; i++) cin >> map[i];
	init();
	bfs();

	cout << check[dest.x][dest.y][dest.dir] << endl;
	return 0;
}