#include <cstdio>
#define MAX_SIZE 100001

int N, Q, height, x, y, a, b;
long long segTree[MAX_SIZE * 4];

void init()
{
	for (register int i = (1 << height) - 1; i > 0; i--) {
		segTree[i] = segTree[i * 2] + segTree[i * 2 + 1];
	}
}

long long query(int left, int right, int curNum, int curLeft, int curRight)
{
	if (right < curLeft || curRight < left) return 0;
	if (left <= curLeft && curRight <= right) return segTree[curNum];

	int mid = (curLeft + curRight) / 2;
	return query(left, right, curNum * 2, curLeft, mid) + query(left, right, curNum * 2 + 1, mid + 1, curRight);
}

void update(int index)
{
	while (index > 1)
	{
		index /= 2;
		segTree[index] = segTree[index * 2] + segTree[index * 2 + 1];
	}
}

int main()
{
	scanf("%d %d", &N, &Q);
	while ((1 << height) < N) height++;
	for (register int i = 0; i < N; i++)
	{
		scanf("%lld", &segTree[(1 << height) + i]);
	}
	init();
	for (register int i = 0; i < Q; i++) {
		scanf("%d %d %d %d", &x, &y, &a, &b);
		if (y < x) {
			int temp = x;
			x = y;
			y = temp;
		}
		printf("%lld\n", query(x-1, y-1, 1, 0, (1 << height) - 1));
		segTree[(1 << height) + a-1] = b;
		update((1 << height) + a-1);
	}
	return 0;
}