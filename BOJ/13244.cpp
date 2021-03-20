#include <iostream>
using namespace std;

int tc, N, M, edge[1001][1001], from, to, cnt;
bool visit[1001];
int stack[1001], top;

void init()
{
	top = -1;
	cnt = 0;
	for (register int i = 1; i <= N; i++) {
		visit[i] = false;
		for (register int j = 1; j <= N; j++) edge[i][j] = 0;
	}

	for (register int i = 0; i < M; i++) {
		scanf("%d%d", &from, &to);
		edge[from][to]++;
		edge[to][from]++;
	}
}

bool solve()
{
	stack[++top] = 1;

	while (top != -1)
	{
		int cur = stack[top];
		top--;
		for (register int i = 1; i <= N; i++)
		{
			if (edge[cur][i] > 1) return false;
			else if (edge[cur][i] == 1)
			{
				if (!visit[i]) {
					stack[++top] = i;
				}
			}
		}
		visit[cur] = true;
		cnt++;
	}

	if (cnt != N) return false;
	for (register int i = 1; i <= N; i++) {
		if (!visit[i]) return false;
	}
	return true;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d%d", &N, &M);
		init();
		if (solve()) printf("tree\n");
		else printf("graph\n");
	}
	return 0;
}