#include <iostream>
#include <queue>
using namespace std;

#define INF -2123456789
typedef struct a {
	int to;
	int cost;
	a* left;
	a* right;
	a() {
		to = 0;
		cost = 0;
		left = 0;
		right = 0;
	}
}Way;

typedef struct b {
	int cur;
	long long curCost;
}Info;

struct cmp {
	bool operator()(Info a, Info b)
	{
		return a.curCost > b.curCost;
	}
};
int N, start, desti, M, from, to, cost;
long long arr[101];
int visitCost[101], visitCnt[101];
bool visit[101];
Way wayPool[101];
int wayCnt;
Way *ways[101];

bool checkPossible()
{
	queue<int> q;
	q.push(start);
	visit[start] = true;

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		Way *ptr = ways[cur];
		
		while (ptr != 0)
		{
			int next = ptr->to;
			if (!visit[next]) {
				visit[next] = true;
				q.push(next);
			}
			ptr = ptr->right;
		}
	}

	if (visit[desti] == false) return false;

	return true;
}

bool dijkstra()
{
	priority_queue<Info, vector<Info>, cmp> pq;
	pq.push({ start, visitCost[start] });
	arr[start] = visitCost[start];

	while(!pq.empty())
	{
		Info cur = pq.top();
		pq.pop();

		if (cur.curCost < arr[cur.cur]) continue;

		int curIndex = cur.cur;
		long long curCost = cur.curCost;
		visitCnt[curIndex]++;
		if (visitCnt[curIndex] > 3 * N) return false;
		Way *ptr = ways[curIndex];
		
		while (ptr != 0)
		{
			int next = ptr->to;
			int nextCost = ptr->cost;

			if (arr[next] < curCost + visitCost[next] - nextCost) {
				arr[next] = curCost + visitCost[next] - nextCost;
				pq.push({ next, arr[next] });
			}
			ptr = ptr->right;
		}
	}
	return true;
}

int main()
{
	scanf("%d%d%d%d", &N, &start, &desti, &M);
	for (register int i = 0; i < M; i++) {
		scanf("%d%d%d", &from, &to, &cost);

		wayPool[wayCnt].to = to;
		wayPool[wayCnt].cost = cost;
		
		if (ways[from] == 0) {
			ways[from] = &wayPool[wayCnt];
		}
		else {
			wayPool[wayCnt].right = ways[from];
			ways[from]->left = &wayPool[wayCnt];
			ways[from] = &wayPool[wayCnt];
		}

		wayCnt++;
	}
	for (register int i = 0; i < N; i++) {
		scanf("%d", visitCost + i);
		arr[i] = INF;
	}
	if (!checkPossible()) {
		printf("gg\n");
	}
	else {
		if (!dijkstra() && visitCnt[desti] > 2*N) {
			printf("Gee\n");
		}
		else printf("%lld\n", arr[desti]);
	}

	return 0;
}