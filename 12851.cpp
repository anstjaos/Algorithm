#include<cstdio>
#include <queue>
using namespace std;

typedef struct {
	int cur;
	int cnt;
}Pos;

int N, K, result, cnt;
int visit[100005];

void bfs()
{
	queue<Pos> q;
	q.push({ N, 0 });
	visit[N] = true;

	while (!q.empty())
	{
		Pos cur = q.front();
		q.pop();

		int nextX = cur.cur - 1;
		if (nextX == K) {
			if (cur.cnt + 1 < result) {
				result = cur.cnt + 1;
				cnt = 1;
			}
			else if (cur.cnt + 1 == result) cnt++;
		}
		else if (nextX >= 0 && (visit[nextX] == 0 || visit[nextX] >= cur.cnt+1)) {
			visit[nextX] = cur.cnt+1;
			q.push({ nextX, cur.cnt + 1 });
		}

		nextX = cur.cur + 1;
		if (nextX == K) {
			if (cur.cnt + 1 < result) {
				result = cur.cnt + 1;
				cnt = 1;
			}
			else if (cur.cnt + 1 == result) cnt++;
		}
		else if (nextX < 100001 && (visit[nextX] == 0 || visit[nextX] >= cur.cnt + 1)) {
			visit[nextX] = cur.cnt+1;
			q.push({ nextX, cur.cnt + 1 });
		}

		nextX = cur.cur * 2;
		if (nextX == K) {
			if (cur.cnt + 1 < result) {
				result = cur.cnt + 1;
				cnt = 1;
			}
			else if (cur.cnt + 1 == result) cnt++;
		}
		else if (nextX > K) {
			if (nextX - K + cur.cnt + 1 < result) {
				result = nextX - K + cur.cnt + 1;
				cnt = 1;
			}
			else if (nextX - K + cur.cnt + 1 == result) cnt++;
		}
		else if (nextX < 100001 && (visit[nextX] == 0 || visit[nextX] >= cur.cnt + 1)) {
			visit[nextX] = cur.cnt+1;
			q.push({ nextX, cur.cnt + 1 });
		}
	}
}

int main()
{
	scanf("%d %d", &N, &K);
	result = 2123456789;

	if (N == K)
	{
		result = 0;
		cnt = 1;
	}
	else bfs();
	printf("%d\n%d\n", result, cnt);
	return 0;
}