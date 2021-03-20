#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int tc, n, m, coin[501], want[501], inEdge[501], order[501], result;
vector<int> arr[501];

int min(int a, int b) { return (a < b ? a : b); }
bool comp(const int &a, const int &b) 
{
	return inEdge[a] < inEdge[b];
}

void init()
{
	result = 2123456789;
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++)
	{
		arr[i].clear();
		order[i] = i;
	}

	int a, b;
	for (int i = 0; i < m; i++)
	{
		scanf("%d %d", &a, &b);
		arr[a].push_back(b);
		arr[b].push_back(a);
		inEdge[a]++;
		inEdge[b]++;
	}

	for (int i = 1; i <= n; i++) scanf("%d", &want[i]);
	for (int i = 1; i <= n; i++) scanf("%d", &coin[i]);

	sort(order + 1, order + n+1, comp);

}

bool isSatisfied() 
{
	for (int i = 1; i <= n; i++)
	{
		if (want[i] != coin[i]) return false;
 	}
	return true;
}

void dfs(int cnt, int cur, int before)
{
	if (isSatisfied())
	{
		result = min(result, cnt);
		return;
	}
	 
	int temp;
	for (int next : arr[cur])
	{
		if (inEdge[next] == 1)
		{
			if ((coin[next] != want[next]) && coin[cur] == want[next])
			{
				temp = coin[next];
				coin[next] = coin[cur];
				coin[cur] = temp;
				cnt++;
			}
		}
		else
		{
			if (coin[cur] != coin[next])
			{
				temp = coin[next];
				coin[next] = coin[cur];
				coin[cur] = temp;
				dfs(cnt + 1, next, cur);
				coin[cur] = coin[next];
				coin[next] = temp;
			}
			
		}
	}
	//for (int i = 1; i <= n; i++)
	//{
	//	int cur = order[i];
	//	if (want[cur] == coin[cur]) continue;

	//	for (int next : arr[cur])
	//	{
	//		if (next == before) continue;

	//		coin[cur] = !coin[cur];
	//		coin[next] = !coin[next];
	//		dfs(cnt + 1, cur);
	//		coin[cur] = !coin[cur];
	//		coin[next] = !coin[next];
	//		/*if (inEdge[cur] == 1)
	//		{
	//			if (want[cur] == coin[next])
	//			{
	//				coin[cur] = !coin[cur];
	//				coin[next] = !coin[next];
	//				dfs(cnt + 1);
	//				coin[cur] = !coin[cur];
	//				coin[next] = !coin[next];
	//			}
	//		}
	//		else if ((want[next] != coin[next]) && coin[cur] == want[next]) 
	//		{
	//			coin[cur] = !coin[cur];
	//			coin[next] = !coin[next];
	//			dfs(cnt + 1);
	//			coin[cur] = !coin[cur];
	//			coin[next] = !coin[next];
	//		}*/
	//	}
	//}
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		init();
		for (int i = 1; i <= n; i++)
		{
			dfs(0, i, -1);
		}
		printf("%d\n", result);
	}
	return 0;
}