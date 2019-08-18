#include <iostream>
using namespace std;

typedef struct m
{
	int row;
	int col;
	int dir;
}m;

enum {N=0,E,S,W};
m mv[4];
char maze[101][101];

int init()
{
	mv[N].row = -1;
	mv[N].col = 0;

	mv[E].row = 0;
	mv[E].col = 1;

	mv[S].row = 1;
	mv[S].col = 0;

	mv[W].row = 0;
	mv[W].col = -1;
}

int main()
{
	int cnt = 1;
	int row, col;
	m cur;
	init();
	m stack[101];
	int top = 0;
	cin >> row, col;
	char mark[101][101] = { 0, };
	for (int i = 0; i <= row+1; i++)
	{
		maze[i][0] = 0;
		maze[i][col+1] = 0;
	}
	for (int j = 0; j <= col+1; j++)
	{
		maze[0][j] = 0;
		maze[row + 1][j] = 0;
	}
	for (int i = 1; i < row + 1; i++)
	{
		for (int j = 1; j < col + 1; j++)
		{
			cin >> maze[i][j];
		}
	}
	
	cur = { 1, 1, N };
	bool flag = false;
	while (1)
	{
		int nextD = cur.dir + 1;
		int nextX = cur.row + mv[nextD].row;
		int nextY = cur.col + mv[nextD].col;

		for(int i = 0; i < 4 ; i++)
		{
			int nextD = cur.dir + 1;
			int nextX = cur.row + mv[i].row;
			int nextY = cur.col + mv[i].col;

			if (nextX == row && nextY == col)
			{
				flag = true;
				break;
			}

			if (maze[nextX][nextY] == 0) continue;
			else if (mark[nextX][nextY] != 0) continue;
			
			mark[nextX][nextY] = 1;
			m next = { nextX, nextY, nextD };
			stack[top++] = next;
		}
		if (flag == true) break;
	}
	
}