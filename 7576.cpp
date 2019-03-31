#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}mv;

int dirX[4] = { -1 ,0, 1, 0 };
int dirY[4] = { 0,1,0,-1 };
int tomato[1001][1001];
int row, col, front, rear, result = 0;
int visit[1001][1001];
mv queue[1000001];

void push(mv item)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 1000001;
}

mv getFront()
{
	int temp = (front + 1) % 1000001;
	return queue[temp];
}

bool checkTomato()
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (tomato[i][j] == 0) return false;
		}
	}
	return true;
}

void bfs()
{
	front = rear = -1;
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (tomato[i][j] == 1)
			{
				push({ i,j});
				visit[i][j] = 0;
			}
			else visit[i][j] = -1;
		}
	}

	int nextX, nextY;
	mv cur;
	while (front != rear)
	{
		cur = getFront();
		pop();
		
		for (int i = 0; i < 4; i++)
		{
			nextX = cur.x + dirX[i];
			nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

			if (tomato[nextX][nextY] == 0)
			{
				tomato[nextX][nextY] = 1;
				visit[nextX][nextY] = visit[cur.x][cur.y] + 1;
				push({ nextX, nextY });
			}
		}
	}
}


int main()
{
	cin >> col >> row;
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++) cin >> tomato[i][j];
	}

	bfs();
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (tomato[i][j] == 0)
			{
				cout << -1 << endl;
				return 0;
			}
			
			if (visit[i][j] > result) result = visit[i][j];
		}
	}
	cout << result << endl;
	return 0;
}