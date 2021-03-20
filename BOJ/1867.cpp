#include <stdio.h>
#include <vector>
using namespace std;

vector<int> graph[505];
bool check[505];
int pred[505];
int n, k;

bool dfs(int cur)
{
	if (cur == -1) return true;

	for (int next : graph[cur])
	{
		if (check[next]) continue;
		check[next] = true;
		
		if (dfs(pred[next])) {
			pred[next] = cur;
			return true;
		}
	}

	return false;
}

int main()
{
	scanf("%d %d", &n, &k);
	int a, b;
	for (register int i = 0; i < k; i++)
	{
		scanf("%d %d", &a, &b);
		graph[a - 1].push_back(b - 1);
	}

	for (register int i = 0; i < n; i++) pred[i] = -1;

	int ans = 0;
	for (register int i = 0; i < n; i++) {
		for (register int j = 0; j < n; j++) check[j] = false;

		if (dfs(i))
		{
			ans += 1;
		}
	}

	printf("%d\n", ans);
	return 0;
}