#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

#define MAX_INF 2123456789
int tc, n, m, t, s, g, h, arr[2001][2001], a, b, d;
int candidate[101], dist1[2001], dist2[2001];
int min(int a, int b) { return (a < b ? a : b); }

void findShortest()
{
	bool inQ[2001];
	for (register int i = 1; i <= n; i++) inQ[i] = false;
	queue<int> q;
	q.push(s);
	inQ[s] = true;
	dist1[s] = 0;

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		inQ[cur] = false;

		for (register int i = 1; i <= n; i++)
		{
			if (arr[cur][i] != MAX_INF)
			{
				if (dist1[i] > dist1[cur] + arr[cur][i])
				{
					dist1[i] = dist1[cur] + arr[cur][i];
					if (inQ[i] == false) {
						inQ[i] = true;
						q.push(i);
					}
				}
				
			}
		}
	}
}

void dijkstra(int start)
{
	bool inQ[2001];
	for (register int i = 1; i <= n; i++) inQ[i] = false;
	queue<int> q;
	q.push(start);
	inQ[start] = true;
	dist2[start] = dist1[start];

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		inQ[cur] = false;

		for (register int i = 1; i <= n; i++)
		{
			if (arr[cur][i] != MAX_INF)
			{
				if (dist2[i] > dist2[cur] + arr[cur][i])
				{
					dist2[i] = dist2[cur] + arr[cur][i];
					if (inQ[i] == false) {
						inQ[i] = true;
						q.push(i);
					}
				}
			}
		}
	}
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d %d %d", &n, &m, &t);
		scanf("%d %d %d", &s, &g, &h);
		for (register int i = 1; i <= n; i++) {
			for (register int j = 1; j <= n; j++) arr[i][j] = MAX_INF;
			dist1[i] = MAX_INF;
			dist2[i] = MAX_INF;
		}

		for (register int i = 0; i < m; i++) {
			scanf("%d %d %d", &a, &b, &d);
			arr[a][b] = min(arr[a][b], d);
			arr[b][a] = min(arr[b][a], d);
		}

		for (register int i = 0; i < t; i++) {
			scanf("%d", candidate + i);
		}

		findShortest();
		int start = g;
		if (dist1[g] < dist1[h]) start = h;

		dijkstra(start);
		sort(candidate, candidate + t);
		for (register int i = 0; i < t; i++)
		{
			int cur = candidate[i];
			if (dist1[cur] == MAX_INF || dist2[cur] == MAX_INF) continue;
			if (dist1[cur] == dist2[cur]) { printf("%d ", cur); }
		}
		printf("\n");
	}

	return 0;
}