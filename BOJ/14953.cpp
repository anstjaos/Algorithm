#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, start, dest, result = -1;
vector<int> arr[100001];
int cnt[100001], order[100001], dp[100001];

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++)
	{
		scanf("%d %d", &start, &dest);
		arr[start].push_back(dest);
		arr[dest].push_back(start);

		cnt[start]++;
		cnt[dest]++;
	}

	for (int i = 0; i < n; i++)
	{
		dp[i] = 1;
		order[i] = i;
	}
	sort(order, order + 1, [](const int &a, const int &b)
	{
		return cnt[a] < cnt[b];
	});

	for (int i = 0; i < n; i++)
	{
		int c = order[i];
		for (int t : arr[c])
		{
			if (cnt[c] < cnt[t])dp[t] = max(dp[t], dp[c] + 1);

		}
	}
	for (int i = 0; i < n; i++) result = max(result, dp[i]);
	printf("%d\n", result);
	return 0;
}f