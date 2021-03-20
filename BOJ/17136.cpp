#include <iostream>
using namespace std;

#define INF 2123456789
#define SIZE 10
int map[11][11], color[6] = { 0,5,5,5,5,5 }, result;
int min(int a, int b) { return (a < b ? a : b); }

bool isPossible(int x, int y, int size)
{
	int nextX, nextY;
	for (register int i = 0; i < size; i++) {
		for (register int j = 0; j < size; j++) {
			nextX = x + i;
			nextY = y + j;
			if (nextX >= SIZE || nextY >= SIZE) return false;
			if (map[nextX][nextY] == 0) return false;
		}
	}
	return true;
}

void changeMap(int x, int y, int size, int val)
{
	for (register int i = 0; i < size; i++) {
		for (register int j = 0; j < size; j++) {
			map[x + i][y + j] = val;
		}
	}
}

void dfs()
{
	int x = -1, y = -1;
	for (register int i = 0; i < SIZE; i++) {
		for (register int j = 0; j < SIZE; j++) {
			if (map[i][j] == 1) {
				x = i;
				y = j;
				break;
			}
		}
		if (x != -1) break;
	}

	if (x== -1) {
		int cnt = 0;
		for (register int i = 1; i < 6; i++) {
			cnt += 5 - color[i];
		}
		result = min(result, cnt);
		return;
	}

	for (register int i = 5; i > 0; i--) {
		if (color[i] == 0) continue;
		if (isPossible(x, y, i)) {
			color[i]--;
			changeMap(x, y, i, 0);
			dfs();
			color[i]++;
			changeMap(x, y, i, 1);
		}
	}
}

int main()
{
	result = INF;
	for (register int i = 0; i < SIZE; i++) {
		for (register int j = 0; j < SIZE; j++) scanf("%d", &map[i][j]);
	}

	dfs();
	result == INF ? printf("-1\n") : printf("%d\n", result);
	return 0;
}