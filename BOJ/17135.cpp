#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

typedef struct {
	int x;
	int y;
}Point;
int N, M, D, map[16][16], result;
bool archer[16];

queue<Point> diedEnemy, turnEnemy;

void killEnemy(int arc, int curRow)
{
	int d = 2123456789;
	int x = 0;
	int y = 2123456789;
	for (register int i = 0; i < M; i++) {
		for (register int j = 1; j <= D; j++) {
			if (curRow - j < 0) break;
			int dist = j + abs(arc - i);
			if (map[curRow-j][i] == 1 && dist <= D) {
				if (dist < d || (dist == d && i < y)) {
					d = dist;
					y = i;
					x = curRow - j;
				}
			}
		}
	}
	if (y != 2123456789) {
		turnEnemy.push({ x,y });
	}
}
	
void findSum()
{
	int sum = 0;
	
	for (register int i = N; i >= 1; i--) {
		for (register int j = 0; j < M; j++) {
			if (archer[j]) {
				killEnemy(j, i);
			}
		}
		
		
		while(!turnEnemy.empty()) {
			Point cur = turnEnemy.front();
			turnEnemy.pop();
			
			if (map[cur.x][cur.y] == 1) {
				diedEnemy.push(cur);
				map[cur.x][cur.y] = 0;
				sum++;
			}
		}
	}
	while (!diedEnemy.empty()) {
		Point cur = diedEnemy.front();
		diedEnemy.pop();

		map[cur.x][cur.y] = 1;
	}
	result = max(result, sum);
}

void solve(int cnt, int pre)
{
	if (cnt == 3) {
		findSum();
		return;
	}

	for (register int i = pre+1; i < M; i++) {
		if (archer[i] == false) {
			archer[i] = true;
			solve(cnt + 1, i);
			archer[i] = false;
		}
	}
}

int main()
{
	scanf("%d%d%d", &N, &M, &D);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < M; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	solve(0, -1);
	printf("%d\n", result);
	return 0;
}