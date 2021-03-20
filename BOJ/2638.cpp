#include <iostream>
using namespace std;

typedef struct {
	bool cheeze;
	int airCnt;
}cz;

typedef struct {
	int x, y;
}pt;

pt queue[100001];
int front, rear;
cz map[101][101];
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 }, result;
int row, col;

void push(pt item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

pt getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

bool checkMap()
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++) if (map[i][j].cheeze == 1) return false;
	}
	return true;
}

bool checkDir(pt start)
{
	bool visit[101][101];
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++) visit[i][j] = false;
	}

	front = rear = -1;
	push(start);
	visit[start.x][start.y] = true;
	pt cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (map[nextX][nextY].cheeze == 1 || visit[nextX][nextY] == true) continue;

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) return true;

			visit[nextX][nextY] = true;
			push({ nextX,nextY });
		}
	}

	return false;
}

void solve()
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j].cheeze == 1)
			{
				for (int k = 0; k < 4; k++)
				{
					int nextX = i + dirX[k];
					int nextY = j + dirY[k];

					if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col)
					{
						map[i][j].airCnt++;
						continue;
					}
					if (map[nextX][nextY].cheeze == 1) continue;

					if (checkDir({ nextX,nextY })) map[i][j].airCnt++;
				}
			}
		}
	}
}

void changeMap()
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j].cheeze == 1)
			{
				if (map[i][j].airCnt >= 2) map[i][j].cheeze = false;

				map[i][j].airCnt = 0;
			}
		}
	}
}

int main()
{
	cin >> row >> col;

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++) cin >> map[i][j].cheeze;
	}

	while (1)
	{
		if (checkMap()) break;
		solve();
		changeMap();
		result++;
	}

	cout << result << '\n';
	return 0;
}