#include <iostream>
using namespace std;

typedef struct a{
	int x, y, key;
}mv;

char map[51][51];
int row, col, front, rear, check[51][51][1 << 7];
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
mv queue[5000], start;

void push(mv item)
{
	rear = (rear + 1) % 5000;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 5000;
}

mv getFront()
{
	int temp = (front + 1) % 5000;
	return queue[temp];
}

int bfs(mv start)
{
	front = rear = -1;
	push(start);
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (map[cur.x][cur.y] == '1') return check[cur.x][cur.y][cur.key];

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];
			
			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if (check[nextX][nextY][cur.key] != 0) continue;
			if (map[nextX][nextY] == '#') continue;

			if ('a' <= map[nextX][nextY] && map[nextX][nextY] <= 'f')
			{
				int temp = cur.key | (1 << (map[nextX][nextY] - 'a'));

				if (check[nextX][nextY][temp] == 0)
				{
					check[nextX][nextY][cur.key] = check[cur.x][cur.y][cur.key] + 1;
					check[nextX][nextY][temp] = check[cur.x][cur.y][cur.key] + 1;
					push({ nextX,nextY,temp });
				}
			}
			else if ('A' <= map[nextX][nextY] && map[nextX][nextY] <= 'F')
			{
				int temp = cur.key & (1 << (map[nextX][nextY] - 'A'));
				
				if (temp != 0)
				{
					check[nextX][nextY][cur.key] = check[cur.x][cur.y][cur.key] + 1;
					push({ nextX,nextY,cur.key });
				}
				
			}
			else if (check[nextX][nextY][cur.key] == 0)
			{
				check[nextX][nextY][cur.key] = check[cur.x][cur.y][cur.key] + 1;
				push({ nextX, nextY,cur.key });
			}
		}
	}
	return -1;
}

int main()
{
	cin >> row >> col;
	for (int i = 0; i < row; i++) cin >> map[i];

	bool flag = false;
	
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j] == '0')
			{
				start = { i,j,0 };
				flag = true;
			}
		}
		if (flag == true) break;
	}

	cout << bfs(start) << endl;

	return 0;
}