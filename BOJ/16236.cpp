#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

typedef struct {
	int x;
	int y;
}Point;

struct cmp
{
	bool operator()(Point a, Point b) {
		if (a.x > b.x) return true;
		else if (a.x == b.x) {
			return a.y > b.y;
		}
		return a.x > b.x;
	}
};
int N, map[21][21], curX, curY, result, shark = 2, feed = 0;
int dirX[4] = { -1,0,0,1 }, dirY[4] = { 0, -1, 1, 0 };
queue<Point> q;
priority_queue<Point, vector<Point>, cmp > pq;
bool visit[21][21];

bool bfs()
{
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) visit[i][j] = false;
	}
	if (feed == shark) {
		shark++;
		feed = 0;
	}
	while (!q.empty()) q.pop();
	while (!pq.empty()) pq.pop();

	q.push({ curX, curY });
	visit[curX][curY] = true;
	int dist = 0;

	while (!q.empty()) {
		dist++;
		int size = q.size();
		for (register int s = 0; s < size; s++)
		{
			Point cur = q.front();
			q.pop();
			for (register int i = 0; i < 4; i++) {
				int nextX = cur.x + dirX[i];
				int nextY = cur.y + dirY[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if (visit[nextX][nextY]) continue;
				if (map[nextX][nextY] != 0 && map[nextX][nextY] < shark) {
					pq.push({ nextX, nextY });
					visit[nextX][nextY] = true;
				}
				else if (map[nextX][nextY] <= shark) {
					q.push({ nextX, nextY });
					visit[nextX][nextY] = true;
				}
			}
		}

		if (!pq.empty())
		{
			Point next = pq.top();
			feed++;
			map[next.x][next.y] = 0;
			result += dist;
			curX = next.x;
			curY = next.y;
			return true;
		}
	}

	return false;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++)
		{
			scanf("%d", &map[i][j]);
			if (map[i][j] == 9) {
				curX = i;
				curY = j;
				map[i][j] = 0;
			}
		}
	}

	while (1)
	{
		if (!bfs()) break;
	}

	printf("%d\n", result);
}