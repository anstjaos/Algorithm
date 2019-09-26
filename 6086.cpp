#include <stdio.h>
#define INF 2123456789

int N;
char from, to;
int f, flow[55][55];
bool visit[55];

int max(int a, int b) { return (a > b ? a : b); }
int min(int a, int b) { return (a < b ? a : b); }

int dfs(int cur, int minFlow)
{
	if (cur == 25) {
		return minFlow;
	}
	visit[cur] = true;
	for (register int i = 0; i < 55; i++) {
		if (flow[cur][i] > 0 && !visit[i]) {
			int t = dfs(i, min(minFlow, flow[cur][i]));
			
			if (t > 0) {
				flow[cur][i] -= t;
				flow[i][cur] += t;
				return t;
			}
		}
	}
	return 0;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf(" %c %c %d", &from, &to, &f);
		int fIndex = (('A' <= from && from <= 'Z') ? from - 'A' : (from - 'a') + 26);
		int tIndex = (('A' <= to && to <= 'Z') ? to - 'A' : (to - 'a') + 26);
		flow[fIndex][tIndex] += f;
		flow[tIndex][fIndex] += f;
	}

	int sum = 0;
	while (1)
	{
		for (register int i = 0; i < 55; i++) visit[i] = false;
		int t = dfs(0, INF);
		if (t == 0) break;
		sum += t;
	}

	printf("%d\n", sum);
	return 0;
}