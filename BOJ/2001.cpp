#include <cstdio>

int island[101][101], n, m, k, dp[101][1<<15], res;
bool jewerly[101];

int max(int a, int b) { return (a > b ? a : b); }

void solve(int cur, int visited, int cnt)
{
	if (cur == 1) {

	}
}

int main()
{
	int temp;
	scanf("%d %d %d", &n, &m, &k);
	for (register int i = 0; i < k; i++) {
		scanf("%d", &temp);
		jewerly[temp] = true;
	}

	int a, b, c;
	for (register int i = 0; i < m; i++) {
		scanf("%d %d %d", &a, &b, &c);
		island[a][b] = max(island[a][b], c);
		island[b][a] = max(island[b][a], c);
	}

	if (jewerly[1] == true)
	{
		int visit = (1 << 1);
		for (register int i = 2; i <= n; i++) {

		}
	}
}