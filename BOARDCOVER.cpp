#include <iostream>
using namespace std;

int dir[4][2][2] = { {{0,1}, {1,0}}, {{0,1}, {1,1}}, {{1,0}, {1,1}}, {{1,-1}, {1,0}} };
int tc, row, col, blankCnt, result, check[21][21];
char map[21][21];

bool possible(int x, int y, int type, int val) 
{
	bool ok = true;
	for (register int i = 0; i < 2; i++) {
		int nextX = x + dir[type][i][0];
		int nextY = y + dir[type][i][1];
		if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) {
			ok = false;
		}
		else if ((check[nextX][nextY] += val) > 1) ok = false;
	}
	return ok;
}

int solve()
{
	int x = -1, y = -1;
	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			if (check[i][j] == 0) {
				x = i;
				y = j;
				break;
			}
		}
		if (x != -1) break;
	}

	if (x == -1) return 1;

	int cnt = 0;
	for (register int i = 0; i < 4; i++) {
		if (possible(x, y, i, 1)) {
			check[x][y] = 1;
			cnt += solve();
		}
		check[x][y] = 0;
		possible(x, y, i, -1);
	}
	return cnt;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d%d", &row, &col);

		result = 0;
		blankCnt = 0;
		for (register int i = 0; i < row; i++) {
			for (register int j = 0; j < col; j++) check[i][j] = 0;
		}
		for (register int i = 0; i < row; i++) {
			scanf("%s", map[i]);
			for (register int j = 0; j < col; j++) {
				if (map[i][j] == '.')
				{
					blankCnt++;
				}
				else check[i][j] = 1;
			}
		}

		if (blankCnt % 3 != 0) {
			printf("0\n");
			continue;
		}

		result = solve();
		printf("%d\n", result);
	}
	return 0;
}