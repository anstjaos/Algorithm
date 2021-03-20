#include <iostream>
#define DIV 1000000007
#define INF -1

int N, M, K, a, b, c, height;
long long arr[4000001];

long long findResult(int left, int right, int cur, int curL, int curR)
{
	if (right < curL || curR < left) return 1;
	if (left <= curL && curR <= right) return arr[cur];

	int mid = (curL + curR) / 2;
	return (findResult(left, right, cur * 2, curL, mid) * findResult(left, right, cur * 2 + 1, mid + 1, curR)) % DIV;
}

int main()
{
	scanf("%d %d %d", &N, &M, &K);
	while ((1 << height) < N) height++;

	for (register int i = 0; i < N; i++) scanf("%lld", arr + (1 << height) + i);
	for (register int i = (1 << height) + N; i < 1 << (height + 1); i++) arr[i] = INF;

	for (register int i = height - 1; i >= 0; i--)
	{
		for (register int j = 1<< i; j < 1 << (i+1); j++)
		{
			if (arr[j * 2] == INF && arr[j * 2 + 1] == INF) arr[j] = 1;
			else if (arr[j * 2] == INF) arr[j] = arr[j * 2 + 1];
			else if (arr[j * 2 + 1] == INF) arr[j] = arr[j * 2];
			else arr[j] = (arr[j * 2] * arr[j * 2 + 1]) % DIV;
		}
	}

	for (register int i = 0; i < K + M; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		if (a == 1)
		{
			int temp = (1 << height) + b - 1;
			arr[temp] = c;
			temp = temp / 2;
			while (temp > 0)
			{
				if (arr[temp * 2] == INF && arr[temp * 2 + 1] == INF) arr[temp] = 1;
				else if (arr[temp * 2] == INF) arr[temp] = arr[temp * 2 + 1];
				else if (arr[temp * 2 + 1] == INF) arr[temp] = arr[temp * 2];
				else arr[temp] = (arr[temp * 2] * arr[temp * 2 + 1]) % DIV;
			
				temp = temp / 2;
			}
		}
		else printf("%lld\n", findResult(b, c, 1, 1, (1<<height)));
	}

	return 0;
}