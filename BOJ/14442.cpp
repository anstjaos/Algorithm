#include <iostream>
#include <queue>
using namespace std;

typedef struct {
	int x;
	int y;
	int wall;
}pt;

int N, M, K, check[1001][1001][10];
char map[1001][1001];
int dirX[4] = { 0,1,0,-1 };
int dirY[4] = { 1,0,-1,0 };

int min(int a, int b) { return (a < b ? a : b); }

void bfs()
{
	queue<pt> q;
	q.push({ 0,0,0 });

	while (!q.empty())
	{
		pt cur = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

			if (map[nextX][nextY] == '0') {
				if (check[nextX][nextY][cur.wall] == 0) {
					check[nextX][nextY][cur.wall] = check[cur.x][cur.y][cur.wall] + 1;
					q.push({ nextX, nextY, cur.wall });
				}
				else if (check[nextX][nextY][cur.wall] > check[cur.x][cur.y][cur.wall] + 1) {
					check[nextX][nextY][cur.wall] = check[cur.x][cur.y][cur.wall] +1;
					q.push({ nextX, nextY, cur.wall });
				}
			}
			else {
				if (cur.wall == K) continue;

				if (check[nextX][nextY][cur.wall+1] == 0 || check[nextX][nextY][cur.wall+1] > check[cur.x][cur.y][cur.wall] + 1) {
					check[nextX][nextY][cur.wall+1] = check[cur.x][cur.y][cur.wall] +1;
					q.push({nextX, nextY, cur.wall+1});
				}
			}
		}
	} 
}

int main()
{
	scanf("%d %d %d", &N, &M, &K);
	for (register int i = 0; i < N; i++) {
		scanf("%s", &map[i]);
	}
	check[0][0][0] = 1;
	bfs();
	
	int result = 2123456789;
	for (int i = 0; i < K; i++) {
		if (check[N - 1][M - 1][i] == 0) continue;

		result = min(result, check[N - 1][M - 1][i]);
	}

	if (result == 2123456789) printf("-1\n");
	else printf("%d\n", result);

	return 0;
}