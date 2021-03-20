#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}block;

int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0, 1, 0, -1 };
block queue[100001];
char puyo[13][7];
int front, rear, result = 0;
bool visit[13][7];

void push(block item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

block getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

bool bfs(int x, int y)
{
	front = rear = -1;
	push({ x,y });

	block cur;
	block arr[100];
	int arrSize = 0;
	
	for (int i = 11; i >= 0; i--)
	{
		for (int j = 0; j < 6; j++)
		{
			visit[i][j] = false;
		}
	}

	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX > 12 || nextY > 6) continue;

			if (puyo[x][y] == puyo[nextX][nextY] && visit[nextX][nextY] == false)
			{
				arr[arrSize++] = { nextX,nextY };
				push({ nextX,nextY });
				visit[nextX][nextY] = true;
			}
		}
	}

	if (arrSize >= 4)
	{
		for (int i = 0; i < arrSize; i++)
		{
			puyo[arr[i].x][arr[i].y] = '.';
		}
		
		return true;
	}
	return false;
}

void setPoint(int x, int y, char target)
{
	int cur = x;
	for (int i = x+1; i < 12; i++)
	{
		if (puyo[i][y] != '.') break;

		cur = i;
	}
	
	puyo[x][y] = '.';
	puyo[cur][y] = target;
}

void resetPuyo()
{
	for (int i = 0; i < 6; i++)
	{
		for (int j = 11; j >= 0; j--)
		{
			if (puyo[j][i] != '.')
			{
				setPoint(j, i, puyo[j][i]);
			}
		}
	}
}

void solve()
{
	bool isChanged = true;

	while (isChanged == true)
	{
		isChanged = false;
		for (int i = 11; i >= 0; i--)
		{
			for (int j = 0; j < 6; j++)
			{
				if (puyo[i][j] != '.')
				{
					if(bfs(i, j) == true) isChanged = true;
				}
			}
		}

		if (isChanged == true)
		{
			result++;
			resetPuyo();
		}
	}
	
}

int main()
{
	for (int i = 0; i < 12; i++) cin >> puyo[i];
	solve();
	cout << result << endl;
	return 0;
}