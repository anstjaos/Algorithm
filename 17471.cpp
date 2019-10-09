#include <stdio.h>
#include <vector>
#include <queue>
using namespace std;

#define INF 2123456789

int N, people[15], res, sum;
vector<int> adjList[15];
bool check[15];

int min(int a, int b) { return (a < b ? a : b); }

void bfs(bool* visit, bool val)
{
	for (register int i = 1; i <= N; i++) visit[i] = !val;
	int start = 0;
	for (register int i = 1; i <= N; i++) {
		if (check[i] == val) {
			start = i;
			break;
		}
	}

	queue<int> q;
	q.push(start);
	visit[start] = val;

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();

		for (int next : adjList[cur])
		{
			if (visit[next] != val && check[next] == val) {
				visit[next] = val;
				q.push(next);
			}
		}
	}
}
int isAllConnected()
{
	int falseCount = 0;
	for (register int i = 1; i <= N; i++) {
		if (!check[i]) falseCount++;
	}
	if (falseCount == 0 || falseCount == N) return -1;

	int sectorA = 0;
	bool visit[15];
	bfs(visit, true);

	for (register int i = 1; i <= N; i++) {
		if (visit[i] != check[i]) return -1;
	}

	bfs(visit, false);
	for (register int i = 1; i <= N; i++) {
		if (visit[i] != check[i]) return -1;
	}

	for (register int i = 1; i <= N; i++) {
		if (check[i]) sectorA += people[i];
	}

	int ret = sum - sectorA * 2;
	if (ret < 0) ret *= -1;

	return ret;
}

void dfs(int depth, int idx)
{
	if (depth == N) {
		int diff = isAllConnected();
		if (diff == -1) return;

		res = min(res, diff);
		return;
	}


	check[idx] = true;
	dfs(depth + 1, idx + 1);
	check[idx] = false;
	dfs(depth + 1, idx + 1);

}

int main()
{
	scanf("%d", &N);
	res = INF;
	for (register int i = 1; i <= N; i++) {
		scanf("%d", people + i);
		sum += people[i];
	}

	for (register int i = 1; i <= N; i++) {
		int cnt = 0, input = 0;
		scanf("%d", &cnt);
		for (register int j = 0; j < cnt; j++) {
			scanf("%d", &input);
			adjList[i].push_back(input);
		}
	}

	dfs(0, 1);
	if (res == INF) printf("-1\n");
	else printf("%d\n", res);
	return 0;
}