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
	// V��ŭ �迭�� INT_MAX�� �ʱ�ȭ
	vector<int> dist(V, INT_MAX);
	dist[src] = 0;

	priority_queue<pii> pq;

	pq.push(make_pair(0, src));

	while (!pq.empty())
	{
		int cost = -pq.top().first;
		int here = pq.top().second;

		pq.pop();

		// ���� ���� ���� �ͺ��� �� ª�� ��θ� �˰� �ִٸ� ���� �������� �����Ѵ�.
		if (dist[here] < cost)
			continue;

		// ������ �������� ��� �˻�.
		for (int i = 0; i < adj[here].size(); i++)
		{
			int there = adj[here][i].first;
			int thereDist = cost + adj[here][i].second;

			// ���� �ִ� �Ÿ��� ã������ ������ �������� ������ �����Ѵ�.
			if (adj[here][i].second == -1)
				continue;

			// �� ª�� ��θ� �߰��ϸ�, dist[]�� �����ϰ� �켱���� ť�� �ִ´�.
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
	// ����, ������ ���� �� ������
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

		// ó�� ���ͽ�Ʈ�� ���� �ִܰŸ��� �ش��ϴ� ������ trace�� ��ƿ´�.
		dijkstra(trace, start, V, E);

		// ť�� �̿��Ͽ� trace�� �ش��ϴ� �������� ��� ���� �غ� �Ѵ�.
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

				// ���� ������ ������ 1->2��� trace���� 2->1�� ���� ����Ǿ��ֱ⿡
				// adj[here][]�� �ƴ� adj[there][]�� �����Ѵ�.
				// * ó�� ������ here�� ���������� �����ϸ� ����. *
				for (int i = 0; i < adj[there].size(); i++)
					if (adj[there][i].first == here)
						adj[there][i].second = -1;

				q.push(there);
			}
		}

		// ���� �ִ� �Ÿ��� ���ϱ����� �ٽ� ���ͽ�Ʈ�� �̿��Ѵ�.
		vector<int> ans = dijkstra(trace, start, V, E);

		// ���� �ִ� ��ΰ� ���� ��� -1
		if (ans[end] == INT_MAX)
			printf("-1\n");
		else
			printf("%d\n", ans[end]);
	}

	return 0;
}