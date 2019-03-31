#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}pt;

int row, col, map[10][10], result = 2123456789;
pt cctv[65];
int cnt;
int min(int a, int b) { return (a < b ? a : b); }
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };

int checkMap()
{
	int r = 0;
	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			if (map[i][j] == 0) r++;
		}
	}
	return r;
}

void changeMap(pt cur, int dir, int check)
{
	int curX = cur.x;
	int curY = cur.y;

	while (1)
	{
		int nextX = curX + dirX[dir];
		int nextY = curY + dirY[dir];

		if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
		if (map[nextX][nextY] == 6) break;

		if (map[nextX][nextY] == 0)
		{
			map[nextX][nextY] = check;
		}

		curX = nextX;
		curY = nextY;
	}
}

void restoreMap( pt cur, int dir, int check)
{
	int curX = cur.x;
	int curY = cur.y;

	while (1)
	{
		int nextX = curX + dirX[dir];
		int nextY = curY + dirY[dir];

		if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) break;
		if (map[nextX][nextY] == 6) break;

		if (map[nextX][nextY] == check)
		{
			map[nextX][nextY] = 0;
		}
		curX = nextX;
		curY = nextY;
	}
}

void dfs(int count)
{
	if (count == cnt) {
		result = min(result, checkMap());
		return;
	}

	pt cur = cctv[count];
	switch (map[cur.x][cur.y]) {
	case 1:
		for (int i = 0; i < 4; i++) {
			changeMap(cur, i, 7+count);
			dfs(count + 1);
			restoreMap(cur, i, 7 + count);
		}
		break;
	case 2:
		for (int i = 0; i < 2; i++) {
			changeMap(cur, i, 7 + count);
			changeMap(cur, i + 2, 7 + count);
			dfs(count + 1);
			restoreMap(cur, i, 7 + count);
			restoreMap(cur, i+2, 7 + count);
		}
		break;
	case 3:
		for (int i = 0; i < 4; i++) {
			changeMap(cur, i, 7 + count);
			changeMap(cur, (i + 1) % 4, 7 + count);
			dfs( count + 1);
			restoreMap(cur, i, 7 + count);
			restoreMap(cur, (i + 1) % 4, 7 + count);
		}
		break;
	case 4:
		for (int i = 0; i < 4; i++) {
			changeMap(cur, i, 7 + count);
			changeMap(cur, (i + 1) % 4, 7 + count);
			changeMap(cur, (i + 2) % 4, 7 + count);
			dfs(count + 1);
			restoreMap(cur, i, 7 + count);
			restoreMap(cur, (i + 1) % 4, 7 + count);
			restoreMap(cur, (i + 2) % 4, 7 + count);
		}
		break;
	case 5:
		changeMap(cur, 0, 7 + count);
		changeMap(cur, 1, 7 + count);
		changeMap(cur, 2, 7 + count);
		changeMap(cur, 3, 7 + count);
		dfs(count + 1);
		restoreMap(cur, 0, 7 + count);
		restoreMap(cur, 1, 7 + count);
		restoreMap(cur, 2, 7 + count);
		restoreMap(cur, 3, 7 + count);
		break;
	}
}

int main()
{
	scanf("%d %d", &row, &col);

	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			scanf("%d", &map[i][j]);
			if (map[i][j] != 0 && map[i][j] != 6) {
				cctv[cnt++] = { i,j };
			}
		}
	}

	dfs(0);
	printf("%d\n", result);
}