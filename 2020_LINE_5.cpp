#include <stdio.h>
#include <queue>
using namespace std;

typedef struct {
	int x;
	int y;
}Pt;

typedef struct {
	Pt cur;
	int count;
}Moon;

struct cmp {
	bool operator()(const Moon& a, const Moon& b)
	{
		if (a.count == b.count) return a.cur.x < b.cur.x;
		return a.count > b.count;
	}
};

int dirX[4] = { -1, 0, 1, 0 }, dirY[4] = { 0, 1, 0, -1 };
int n, m, visit[30][30], cnt[30][30];
Pt conny;

void bfs()
{
	priority_queue<Moon, vector<Moon>, cmp> pq;
	for (register int i = 0; i < 4; i++) {
		int nextX = dirX[i];
		int nextY = dirY[i];

		if (nextX < 0 || nextY < 0 || nextX > n || nextY > m) continue;
		visit[nextX][nextY] = 1;
		cnt[nextX][nextY] = 1;
		pq.push({ {nextX,nextY}, visit[nextX][nextY] });
	}

	while (!pq.empty())
	{
		Moon cur = pq.top();
		pq.pop();

		for (register int i = 0; i < 4; i++) {
			int nextX = cur.cur.x + dirX[i];
			int nextY = cur.cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX > n || nextY > m) continue;
			if (visit[nextX][nextY] == 0 || visit[nextX][nextY] > visit[cur.cur.x][cur.cur.y] + 1) {
				visit[nextX][nextY] = visit[cur.cur.x][cur.cur.y] + 1;
				cnt[nextX][nextY] = cnt[cur.cur.x][cur.cur.y];
				pq.push({ {nextX, nextY}, visit[nextX][nextY] });
			}
			else if (visit[nextX][nextY] == visit[cur.cur.x][cur.cur.y] + 1) {
				cnt[nextX][nextY]+= cnt[cur.cur.x][cur.cur.y];
			}
		}
	}
}

int main()
{
	scanf("%d %d", &m, &n);
	scanf("%d %d", &conny.y, &conny.x);

	if (conny.x < 0 || conny.y < 0 || conny.x > n || conny.y > m) {
		printf("fail\n");
		return 0;
	}
	else if (conny.x == 0 && conny.y == 0) {
		printf("0\n1\n");
		return 0;
	}

	bfs();
	if (visit[conny.x][conny.y] == 0) printf("fail\n");
	else {
		printf("%d\n%d\n", visit[conny.x][conny.y], cnt[conny.x][conny.y]);
	}

	return 0;
}