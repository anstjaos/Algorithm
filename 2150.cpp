#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

typedef struct {
	int count;
	int idx;
}Info;

vector<int> graph[10005];
vector<int> revGraph[10005];
int v, e, visitCnt;
Info cnt[10005];
bool visit[10005];

vector<int> scc[10005];
int sccCount;

bool cmp(const Info& a, const Info& b) 
{
	return a.count > b.count;
}

void dfs(int cur)
{
	visit[cur] = true;
	for (int next : graph[cur]) {
		if (visit[next]) continue;
		dfs(next);
	}
	visitCnt++;
	cnt[visitCnt] = { visitCnt, cur };
}

void revDfs(int cur, int sccCnt)
{
	visit[cur] = true;
	for (int next : revGraph[cur]) {
		if (visit[next]) continue;
		revDfs(next, sccCnt);
	}
	scc[sccCnt].push_back(cur);
}

int main()
{
	scanf("%d %d", &v, &e);
	int a, b;
	for (register int i = 0; i < e; i++) {
		scanf("%d %d", &a, &b);
		graph[a].push_back(b);
		revGraph[b].push_back(a);
	}
	
	for (register int i = 1; i <= v; i++) {
		if (!visit[i]) dfs(i);
	}
	sort(cnt + 1, cnt + v + 1, cmp);
	
	for (register int i = 1; i <= v; i++) visit[i] = false;

	for (register int i = 1; i <= v; i++) {
		if (!visit[cnt[i].idx]) {
			sccCount++;
			revDfs(cnt[i].idx, sccCount);
		}
	}
	for (register int i = 1; i <= sccCount; i++) {
		sort(scc[i].begin(), scc[i].end());
	}

	sort(scc + 1, scc + sccCount+1);
	printf("%d\n", sccCount);
	for (register int i = 1; i <= sccCount; i++) {
		for (int next : scc[i]) printf("%d ", next);
		printf("-1\n");
	}
	return 0;
}