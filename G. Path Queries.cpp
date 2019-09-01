#include <stdio.h>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

typedef struct {
	int idx;
	int weight;
}Edge;

int n, m;
long long arr[200005];
vector<Edge> edgeArr[200004];
bool visit[200004];

int max(int a, int b) { return (a > b ? a : b); }

void bfs(int start)
{
	queue<Edge> q;
	q.push({ start, 0 });
	for (register int i = 1; i <= n; i++) visit[i] = false;
	visit[start] = true;
	
	while (!q.empty()) {
		Edge cur = q.front();
		q.pop();

		for (Edge next : edgeArr[cur.idx])
		{
			if (visit[next.idx]) continue;

			visit[next.idx] = true;
			if (next.idx > start) {
				arr[max(cur.weight, next.weight)]++;
			}

			q.push({ next.idx, max(cur.weight, next.weight) });
		}
	}
}

int main()
{
	scanf("%d %d", &n, &m);
	int s, e, c;
	for (register int i = 0; i < n - 1; i++) {
		scanf("%d %d %d", &s, &e, &c);
		edgeArr[s].push_back({ e,c });
		edgeArr[e].push_back({ s,c });
	}

	for (register int i = 1; i <= n; i++) bfs(i);

	int val;
	for (register int i = 1; i < 200004; i++) arr[i] += arr[i - 1];
	for (register int i = 0; i < m; i++) {
		scanf("%d", &val);
	
		printf("%lld ", arr[val]);
	}

	printf("\n");
	return 0;
}