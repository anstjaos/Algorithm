#include <iostream>
using namespace std;

typedef struct
{
	int row;
	int col;
}m;

int map[52][52];
int mark[52][52];
int result = 0;
m pre;
m cur;
m move1[8] = { {-1,0}, {-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1} };

void init()
{
	result = 0;
	for (int i = 0; i < 52; i++)
	{
		for (int j = 0; j < 52; j++)
		{
			map[i][j] = 0;
			mark[i][j] = 0;
		}
	}
}

void search(int x, int y)
{

	int curD = 0;
	while (curD < 8)
	{
		mark[x][y] = 1;
		int nextX = x + move1[curD].row;
		int nextY = y + move1[curD].col;

		if (map[nextX][nextY] == 1 && mark[nextX][nextY] != 1)
		{
			search(nextX, nextY);
			continue;
		}
		curD++;
	}
}

int main()
{
	int w, h;
	while (1)
	{
		init();
		cin >> w >> h;
		if (w == 0 && h == 0) break;

		for (int i = 1; i <= h; i++)
		{
			for (int j = 1; j <= w; j++) cin >> map[i][j];
		}

		pre = { 1,1 };
		cur = { 1,1 };

		while (1)
		{
			if (pre.row > h) break;
			if (map[cur.row][cur.col] == 0 || mark[cur.row][cur.col] != 0)
			{
				cur.col++;
				if (cur.col > w)
				{
					cur.row++;
					cur.col = 1;
				}
				pre = cur;
				continue;
			}
			if (map[cur.row][cur.col] == 1)
			{
				search(cur.row, cur.col);
				result++;
			}
			
		}
		cout << result << endl;
	}
}
