#include <stdio.h>
#include <queue>
using namespace std;

typedef struct {
	int y;
	int x;
	int dust;
}Dust;

int R, C, T, arr[51][51], uc, dc;
int dirY[4] = { -1, 0 ,1 ,0 }, dirX[4] = { 0,1,0,-1 };

void spread()
{
	queue<Dust> q;
	for (register int i = 0; i < R; i++) {
		for (register int j = 0; j < C; j++) {
			if (arr[i][j] == 0 || arr[i][j] == -1) continue;

			int temp = arr[i][j] / 5;
			for (register int k = 0; k < 4; k++) {
				int nextY = i + dirY[k];
				int nextX = j + dirX[k];

				if (nextY < 0 || nextX < 0 || nextY >= R || nextX >= C || arr[nextY][nextX] == -1) continue;

				q.push({ nextY, nextX, temp });
				arr[i][j] -= temp;
			}
		}
	}

	while (!q.empty())
	{
		Dust d = q.front();
		q.pop();

		arr[d.y][d.x] += d.dust;
	}
}

void clear()
{
	arr[uc - 1][0] = 0;
	for (register int i = uc - 2; i >= 0; i--) {
		arr[i + 1][0] = arr[i][0];
		arr[i][0] = 0;
	}
	
	for (register int i = 1; i < C; i++) {
		arr[0][i - 1] = arr[0][i];
		arr[0][i] = 0;
	}

	for (register int i = 1; i <= uc; i++) {
		arr[i - 1][C - 1] = arr[i][C - 1];
		arr[i][C - 1] = 0;
	}

	for (register int i = C-2; i > 0; i--) {
		arr[uc][i + 1] = arr[uc][i];
		arr[uc][i] = 0;
	}

	arr[dc + 1][0] = 0;
	for (register int i = dc + 2; i < R; i++) {
		arr[i - 1][0] = arr[i][0];
		arr[i][0] = 0;
	}

	for (register int i = 1; i < C; i++) {
		arr[R - 1][i - 1] = arr[R - 1][i];
		arr[R - 1][i] = 0;
	}

	for (register int i = R - 2; i >= dc; i--) {
		arr[i + 1][C - 1] = arr[i][C - 1];
		arr[i][C - 1] = 0;
	}

	for (register int i = C - 2; i > 0; i--) {
		arr[dc][i + 1] = arr[dc][i];
		arr[dc][i] = 0;
	}
}

int main()
{
	scanf("%d %d %d", &R, &C, &T);

	for (register int i = 0; i < R; i++) {
		for (register int j = 0; j < C; j++)
		{
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == -1) {
				if (uc == 0) uc = i;
				else dc = i;
			}
		}
	}

	while (T--)
	{
		spread();
		clear();
	}
	int res = 0;
	for (register int i = 0; i < R; i++) {
		for (register int j = 0; j < C; j++) {
			if (arr[i][j] == -1) continue;

			res += arr[i][j];
		}
	}

	printf("%d\n", res);
	return 0;
}