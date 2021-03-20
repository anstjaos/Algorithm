#include <iostream>
using namespace std;

typedef struct {
	int x, y;
}mv;
int row, col, front, rear, result = -1;
bool visit[51][51];
char map[51][51];
int check[51][51];
mv queue[10001];
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };

void push(mv item)
{
	rear = (rear + 1) % 10001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 10001;
}

mv getFront()
{
	int temp = (front + 1) % 10001;
	return queue[temp];
}

void bfs(mv start)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			visit[i][j] = false;
			check[i][j] = 0;
		}
	}

	front = rear = -1;
	push(start);
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

			if (map[nextX][nextY] == 'L' && visit[nextX][nextY] == false)
			{
				visit[nextX][nextY] = true;
				check[nextX][nextY] = check[cur.x][cur.y]+1;
				push({ nextX,nextY });
			}
		}
	}

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (check[i][j] > result) result = check[i][j];
		}
	}
}
int main()
{
	cin >> row >> col;
	for (int i = 0; i < row; i++) cin >> map[i];

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j] == 'L') bfs({ i,j });
		}
	}

	cout << result << '\n';
	return 0;
}