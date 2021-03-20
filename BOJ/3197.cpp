#include <iostream>
using namespace std;

typedef struct {
	int x, y;
}mv;

char map[1501][1501];
int row, col, front, rear;
mv queue[1000001], start, dest;
bool visit[1501][1501];
int isMelt[1501][1501];
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };

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

int min(int a, int b) { return (a < b ? a : b); }

bool meetSwan(int limit)
{
	front = rear = -1;
	push(start);
	mv cur;
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++) visit[i][j] = false;
	}

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (cur.x == dest.x && cur.y == dest.y) return true;
		if (visit[cur.x][cur.y] == true) continue;
		visit[cur.x][cur.y] = true;

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if (visit[nextX][nextY] == true) continue;

			if (isMelt[nextX][nextY] <= limit)
			{
				push({ nextX, nextY });
			}
		}
	}
	return false;
}

int meltCheck()
{
	front = rear = -1;
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j] == '.' || map[i][j] == 'L') push({ i,j });
		}
	}
	mv cur;

	int maxDate = 0;
	while (front != rear)
	{
		cur = getFront();
		pop();

		if (isMelt[cur.x][cur.y] > maxDate) maxDate = isMelt[cur.x][cur.y];
		

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if (visit[nextX][nextY] == true) continue;

			if (map[nextX][nextY] == 'X')
			{
				if (isMelt[nextX][nextY] == 0) isMelt[nextX][nextY] = isMelt[cur.x][cur.y] + 1;
				else isMelt[nextX][nextY] = min(isMelt[nextX][nextY], isMelt[cur.x][cur.y] + 1);

				visit[nextX][nextY] = true;
				push({ nextX,nextY });
			}
			
		}
	}
	return maxDate;
}

int main()
{
	cin >> row >> col;
	for (int i = 0; i < row; i++)
	{
		cin >> map[i];
	}

	start.x = -1;
	dest.x = -1;

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j] == 'L')
			{
				if (start.x == -1)
				{
					start.x = i;
					start.y = j;
				}
				else
				{
					dest.x = i;
					dest.y = j;
				}
			}
		}
		if (start.x != -1 && dest.x != -1) break;
	}

	int left = 0, right;
	right = meltCheck();

	while (left<=right)
	{
		int mid = (left + right) / 2;
		if (meetSwan(mid) == true) right = mid - 1;
		else left = mid + 1;
	}

	cout << left << '\n';
	return 0;
}