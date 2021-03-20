#include <iostream>
using namespace std;

typedef struct {
	int x, y;
}mv;

mv queue[1000001], start;
int front, rear, row, col, testCase;
int moveNext[1001][1001], fire[1001][1001], dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
char map[1001][1001];

int min(int a, int b) { return (a < b ? a: b); }

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

void fireCheck(mv start)
{
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

			if ((map[nextX][nextY] == '.' || map[nextX][nextY] == '@'))
			{
				if (fire[nextX][nextY] > fire[cur.x][cur.y] + 1)
				{
					fire[nextX][nextY] = fire[cur.x][cur.y] + 1;
					push({ nextX,nextY });
				}
			}
		}
	}
}

void init()
{
	cin >> col >> row;
	
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == '@')
			{
				start.x = i;
				start.y = j;
			}
			moveNext[i][j] = fire[i][j] = 2123456789;
		}
	}

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j] == '*')
			{
				fire[i][j] = 0;
				fireCheck({ i,j });
			}
		}
	}
}

int solve()
{
	front = rear = -1;
	moveNext[start.x][start.y] = 0;
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

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) return moveNext[cur.x][cur.y] + 1;

			if (map[nextX][nextY] == '.' && (moveNext[nextX][nextY] > moveNext[cur.x][cur.y] + 1))
			{
				moveNext[nextX][nextY] = moveNext[cur.x][cur.y] + 1;

				if (moveNext[nextX][nextY] < fire[nextX][nextY]) push({ nextX,nextY });
			}
		}
	}
	return -1;
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		init();
		int result = solve();
		if (result == -1) cout << "IMPOSSIBLE" << '\n';
		else  cout << result << '\n';
	}
	return 0;
}