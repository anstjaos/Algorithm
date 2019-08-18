#include <iostream>
#include <cstdio>
#include <limits.h>
#include <memory.h>
#include <vector>
#include <queue>

using namespace std;

typedef pair<int, int> pii;

vector<pii> adj[20001];
bool visit[501][501];

vector<int> dijkstra(vector<pii> trace[501], int src, int V, int E)
{
	// V만큼 배열을 INT_MAX로 초기화
	vector<int> dist(V, INT_MAX);
	dist[src] = 0;

	priority_queue<pii> pq;

	pq.push(make_pair(0, src));

	while (!pq.empty())
	{
		int cost = -pq.top().first;
		int here = pq.top().second;

		pq.pop();

		// 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸것을 무시한다.
		if (dist[here] < cost)
			continue;

		// 인접한 정점들을 모두 검사.
		for (int i = 0; i < adj[here].size(); i++)
		{
			int there = adj[here][i].first;
			int thereDist = cost + adj[here][i].second;

			// 거의 최단 거리를 찾기위해 삭제된 정점간의 간선을 무시한다.
			if (adj[here][i].second == -1)
				continue;

			// 더 짧은 경로를 발견하면, dist[]를 갱신하고 우선순위 큐에 넣는다.
			if (dist[there] > thereDist)
			{
				dist[there] = thereDist;
				pq.push(make_pair(-thereDist, there));

				trace[there].clear();
				trace[there].push_back(pii(here, thereDist));
			}

			else if (dist[there] == thereDist)
				trace[there].push_back(pii(here, thereDist));

		}
	}

	return dist;
}

int main()
{
	// 정점, 간선의 개수 및 시작점
	int V, E, start, end;

	while (1)
	{
		memset(adj, 0, sizeof(adj));
		memset(visit, false, sizeof(visit));

		scanf("%d %d", &V, &E);
		if (V == 0 && E == 0)
			break;
		scanf("%d %d", &start, &end);


		for (int i = 0; i < E; i++)
		{
			int from, to, val;
			scanf("%d %d %d", &from, &to, &val);

			adj[from].push_back(pii(to, val));
		}


		vector<pii> trace[501];
		memset(trace, 0, sizeof(trace));

		// 처음 다익스트라를 통해 최단거리에 해당하는 정점을 trace에 담아온다.
		dijkstra(trace, start, V, E);

		// 큐를 이용하여 trace에 해당하는 정점들을 모두 지울 준비를 한다.
		queue<int> q;

		q.push(end);
		while (!q.empty())
		{
			int here = q.front();
			q.pop();

			for (int i = 0; i < trace[here].size(); i++)
			{
				int there = trace[here][i].first;

				if (visit[here][there])
					continue;

				// 원래 정점간 연결이 1->2라면 trace에는 2->1로 현재 연결되어있기에
				// adj[here][]가 아닌 adj[there][]로 봐야한다.
				// * 처음 들어오는 here이 도착점임을 생각하면 쉽다. *
				for (int i = 0; i < adj[there].size(); i++)
					if (adj[there][i].first == here)
						adj[there][i].second = -1;

				q.push(there);
			}
		}

		// 거의 최단 거리를 구하기위해 다시 다익스트라를 이용한다.
		vector<int> ans = dijkstra(trace, start, V, E);

		// 거의 최단 경로가 없을 경우 -1
		if (ans[end] == INT_MAX)
			printf("-1\n");
		else
			printf("%d\n", ans[end]);
	}

	return 0;
}