#include <iostream>
#include <queue>
using namespace std;

#define INF 2123456789
bool inQ[501];
int bus[501][501], weight[501];
int check[501], N, M, from, to, cost;

bool solve()
{
	weight[1] = 0;
	queue<int> q;
	for (register int i = 1; i <= N; i++)
	{
		if (bus[1][i] != 0)
		{
			weight[i] = bus[1][i];
			q.push(i);
			inQ[i] = true;
		}
	}

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		inQ[cur] = false;
		check[cur]++;
		if (check[cur] >= 2*N) return false;

		for (register int i = 1; i <= N; i++)
		{
			if (bus[cur][i] != 0)
			{
				if (weight[i] > weight[cur] + bus[cur][i]) {
					weight[i] = weight[cur] + bus[cur][i];
					if (inQ[i] == false) {
						q.push(i);
						inQ[i] = true;
					}
				}
			}
		}
	}

	return true;
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < M; i++)
	{
		scanf("%d %d %d", &from, &to, &cost);
		if (bus[from][to] == 0 || bus[from][to] > cost) bus[from][to] = cost;
	}
	for (register int i = 1; i <= N; i++) weight[i] = INF;
	if (!solve()) printf("-1\n");
	else
	{
		for (register int i = 2; i <= N; i++)
		{
			if (weight[i] == INF) printf("-1\n");
			else printf("%d\n", weight[i]);
		}
	}

	return 0;
}