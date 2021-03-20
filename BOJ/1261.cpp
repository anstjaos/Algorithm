#include <iostream>
using namespace std;

#define MAXINF 2123456789

typedef struct {
	int x, y;
}mv;

int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
char map[101][101];
int check[101][101], front, rear, row, col;
mv queue[100001];

int min(int a, int b) { return (a < b ? a : b); }
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

void bfs()
{
	front = rear = -1;
	push({ 0,0 });
	check[0][0] = 0;
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();


		if (cur.x == row - 1 && cur.y == col - 1) continue;

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			
			if (map[nextX][nextY] == '1')
			{
				if (check[cur.x][cur.y] + 1 < check[nextX][nextY])
				{
					check[nextX][nextY] = check[cur.x][cur.y] + 1;
					push({nextX,nextY });
				}
			}
			else if (map[nextX][nextY] == '0')
			{
				if (check[cur.x][cur.y] < check[nextX][nextY])
				{
					check[nextX][nextY] = check[cur.x][cur.y] ;
					push({ nextX,nextY });
				}
			}
		}
	}
}

int main()
{
	cin >> col >> row;
	for (int i = 0; i < row; i++)
	{
		cin >> map[i];
		for (int j = 0; j < col; j++)
		{
			check[i][j] = MAXINF;
		}
	}

	bfs();

	cout << check[row - 1][col - 1] << '\n';
	return 0;
}