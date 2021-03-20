#include <stdio.h>

int N, M, laptopCount[105], laptopArr[105][105], pred[105];
bool visit[105];

bool dfs(int cur)
{
	if (cur == -1) return true;

	int count = laptopCount[cur];
	for (register int i = 0; i < count; i++) {
		int next = laptopArr[cur][i];
		if (visit[next]) continue;
		visit[next] = true;
		if (dfs(pred[next])) {
			pred[next] = cur;
			return true;
		}
	}

	return false;
}

int main()
{
	scanf("%d %d", &N, &M);
	int a, b;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &a, &b);
		laptopArr[a][laptopCount[a]] = b;
		laptopCount[a]++;
	}

	for (register int i = 1; i <= N; i++) pred[i] = -1;

	int ans = 0;
	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) visit[j] = false;
		if (dfs(i)) {
			ans += 1;
		}
	}

	printf("%d\n", ans);
	return 0;
}