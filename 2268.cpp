#include <cstdio>
#define MAX_SIZE 1000001

int N, Q, a, b, c, height;
long long segTree[MAX_SIZE * 4];

void update(int index)
{
	while (index > 1) {
		index /= 2;
		segTree[index] = segTree[index * 2] + segTree[index * 2 + 1];
	}
}

long long query(int left, int right, int curNum, int curLeft, int curRight)
{
	if (right < curLeft || curRight < left) return 0;
	if (left <= curLeft && curRight <= right) return segTree[curNum];

	int mid = (curLeft + curRight) / 2;
	return query(left, right, curNum * 2, curLeft, mid) + query(left, right, curNum * 2 + 1, mid+1, curRight);
}

int main()
{
	scanf("%d %d", &N, &Q);
	while ((1 << height) < N) height++;
	for (register int i = 0; i < Q; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		if (a == 0) {
			if (b > c) {
				int temp = b;
				b = c;
				c = temp;
			}
			printf("%lld\n", query(b - 1, c - 1, 1, 0, (1 << height) - 1));
		}
		else if (a == 1)
		{
			 segTree[(1 << height) + b - 1] = c;
			 update((1 << height) + b - 1);
		}
	}
	return 0;
}