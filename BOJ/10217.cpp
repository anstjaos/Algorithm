#include <iostream>
#include <queue>
#include <functional>
using namespace std;

typedef struct a {
	int to;
	int cost;
	int days;
	a* left;
	a* right;
	a() {
		cost = 0;
		days = 0;
		left = 0;
		right = 0;
	}
}Way;

typedef struct b {
	int cost;
	int cur;
	int days;
}Info;

struct cmp {
	bool operator()(Info a, Info b) {
		return (a.days > b.days);
	}
};


Way pool[10001];
int poolCnt, tc, N, M, K, u, v, c, d;
Way *ways[101];
int total[101][10001];

int min(int a, int b) { return (a < b ? a : b); }
void init()
{
	poolCnt = 0;
	for (register int i = 0; i <= N; i++) {
		for (register int j = 0; j <= M; j++) total[i][j] = 0;
		ways[i] = 0;
	}
}

void solve()
{
	priority_queue<Info, vector<Info>, cmp> q;
	q.push({ 0,1,0 });

	while (!q.empty())
	{
		Info info = q.top();
		q.pop();
		if (total[info.cur][info.cost] < info.days) continue;
		Way* ptr = ways[info.cur];
		while (ptr != 0)
		{
			int next = ptr->to;
			int nextCost = info.cost + ptr->cost;
			int nextDays = info.days + ptr->days;
			if (nextCost > M)
			{
				ptr = ptr->right;
				continue;
			}

			if (total[next][nextCost] == 0) {
				total[next][nextCost] = nextDays;
				q.push({ nextCost, next, nextDays });
			}
			else {
				if (total[next][nextCost] > nextDays) {
					total[next][nextCost] = nextDays;
					q.push({ nextCost,next, nextDays });
				}
			}
			ptr = ptr->right;
		}
	}
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d%d%d", &N, &M, &K);
		init();
		for (register int i = 0; i < K; i++) {
			scanf("%d%d%d%d", &u, &v, &c, &d);
			pool[poolCnt].to = v;
			pool[poolCnt].cost = c;
			pool[poolCnt].days = d;
			if (ways[u] == 0)
			{
				ways[u] = &pool[poolCnt];
				pool[poolCnt].left = 0;
				pool[poolCnt].right = 0;
			}
			else {
				pool[poolCnt].right = ways[u];
				ways[u]->left = &pool[poolCnt];
				ways[u] = &pool[poolCnt];
			}
			poolCnt++;
		}

		solve();
		int result = 2123456789;
		for (register int i = 0; i <= M; i++) {
			if (total[N][i] == 0) continue;

			result = min(result, total[N][i]);
		}

		if (result == 2123456789) printf("Poor KCM\n");
		else printf("%d\n", result);
	}
	return 0;
}