#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}mv;

char map[204][204];
int row, col, front, rear,dir, result = 0;
mv queue[100001]; 
float temp;

int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };
int moveX[4] = { -1,-1,1,1 };
int moveY[4] = { -1,1,1,-1 };

void push(mv item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

mv getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

int changeDirection(int num,int dir)
{
	if (num == 0) // 천장
	{
		switch (dir)
		{
		case 0:
			dir = 3;
			break;
		case 1:
			dir = 2;
			break;
		default:
			break;
		}
	}
	else if (num == 1) // 왼쪽벽
	{
		switch (dir)
		{
		case 0:
			dir = 1;
			break;
		case 3:
			dir = 2;
			break;
		default:
			break;
		}
	}
	else if (num == 2) // 오른쪽벽
	{
		switch (dir)
		{
		case 1:
			dir = 0;
			break;
		case 2:
			dir = 3;
			break;
		default:
			break;
		}
	}

	return dir;
}

void changeBlock(int x, int y)
{
	front = rear = -1;
	push({ x,y });

	if (map[x][y] == 'B')
	{
		map[x][y] = 'O';
	}
	if (map[x][y] == '.')
	{
		if (x % 2 == 0)
		{
			map[x][y] = '-';
		}
		else if (x % 2 == 1 && y % 2 == 0) map[x][y] = '|';
	}

	mv cur;
	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX > 2 * row || nextY > 2 * col) continue;

			if (map[nextX][nextY] == 'B')
			{
				push({ nextX,nextY });
				map[nextX][nextY] = 'O';
			}
			if (map[nextX][nextY] == '.' )
			{
				push({ nextX,nextY });

				if (nextX % 2 == 0)
				{
					map[nextX][nextY] = '-';
				}
				else if (nextX % 2 == 1 && nextY % 2 == 0) map[nextX][nextY] = '|';
			}
		}
	}
}

void checkBomb(int x, int y, int dir)
{
	int nextX = x + moveX[dir];
	int nextY = y + moveY[dir];

	if (map[nextX][y] == 'B' || map[nextX][y] == '.')
	{
		changeBlock(nextX, y);
		result++;
	}
	if (map[x][nextY] == 'B' || map[x][nextY] == '.')
	{
		changeBlock(x, nextY);
		result++;
	}
	if (map[nextX][nextY] == 'B' || map[nextX][nextY] == '.')
	{
		changeBlock(nextX, nextY);
		result++;
	}
}
	
void pingpong(int start)
{
	dir = 0;
	if (start == 0) dir = 1;
	
	mv cur = { 2 * row , start  };
	while (1)
	{

		checkBomb(cur.x, cur.y, dir);
		cur.x = cur.x + moveX[dir];
		cur.y = cur.y + moveY[dir];
		if (cur.x == 2 * row) break;

		if (cur.x == 0)
		{
			if (cur.y == 0) dir = 2;
			else if (cur.y == 2 * col) dir = 3;
			else dir = changeDirection(0, dir); // 천장
		}
		else if (cur.y == 0) dir = changeDirection(1,dir); // 왼쪽벽
		else if (cur.y == 2 * col)
		{
			dir = changeDirection(2, dir); // 오른쪽벽
		}
	}
}

int main()
{
	cin >> col >> row >> temp;
	for (int i = 0; i <= 2*row; i++) cin >> map[i];
	int start = temp / 0.5;
	pingpong(start);
	cout << result << endl;
	return 0;
}