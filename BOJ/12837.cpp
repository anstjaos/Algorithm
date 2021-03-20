#include <iostream>

typedef long long ll;
int N, Q, a, b, c, height;
ll arr[4000001];

ll findSum(int left, int right, int cur, int curL, int curR)
{
	if (right < curL || curR < left) return 0;
	if (left <= curL && curR <= right) return arr[cur];

	int mid = (curL + curR) / 2;
	return findSum(left, right, cur * 2, curL, mid) + findSum(left, right, cur * 2 + 1, mid + 1, curR);
}

int main()
{
	scanf("%d %d", &N, &Q);
	while ((1 << height) < N) height++;

	for (register int i = 0; i < Q; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		if (a == 1)
		{
			int temp = (1 << height) + b - 1;
			arr[temp] += c;
			temp = temp / 2;
			while (temp > 0)
			{
				arr[temp] = arr[temp * 2] + arr[temp * 2 + 1];
				temp = temp / 2;
			}
		}
		else printf("%lld\n", findSum(b, c, 1, 1, (1<<height)));
	}

	return 0;
}