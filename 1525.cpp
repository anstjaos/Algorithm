#include <stdio.h>

typedef struct {
	int y;
	int x;
}Point;

int map[3][3], dirY[4] = { -1,0,1,0 }, dirX[4] = { 0,1,0,-1 }, result = 2123456789;
Point before;
int min(int a, int b) { return (a < b ? a : b); }

bool check(int arr[3][3])
{
	int num = 1;
	for (register int i = 0; i < 3; i++) {
		for (register int j = 0; j < 3; j++) {
			if (arr[i][j] != num) return false;

			num++;
		}
	}

	return true;
}

void solve(int arr[3][3], int cnt)
{
	if (check(arr)) {
		result = min(result, cnt);
		return;
	}

	int temp[3][3];
	Point zero;
	for (register int i = 0; i < 3; i++) {
		for (register int j = 0; j < 3; j++)
		{
			temp[i][j] = arr[i][j];
			if (arr[i][j] == 0) {
				zero.y = i;
				zero.x = j;
			}
		}
	}

	for (register int i = 0; i < 4; i++)
	{
		int nextY = zero.y + dirY[i];
		int nextX = zero.x + dirX[i];

		if (nextY < 0 || nextX < 0 || nextY >= 3 || nextX >= 3 || (nextY == before.y && nextX == before.x)) continue;

		int tempNum = temp[nextY][nextX];
		before = { zero.y, zero.x };
		temp[nextY][nextX] = 0;
		temp[zero.y][zero.x] = tempNum;
		solve(temp, cnt + 1);
		temp[zero.y][zero.x] = 0;
		temp[nextY][nextX] = tempNum;
	}
}

int main()
{
	for (register int i = 0; i < 3; i++) {
		for (register int j = 0; j < 3; j++) scanf("%d", &map[i][j]);
	}

	solve(map, 0);
	result == 2123456789 ? printf("-1\n") : printf("%d\n", result);
	return 0;
}