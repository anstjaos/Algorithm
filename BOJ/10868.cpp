#include <stdio.h>
#define MAX_SIZE 400005
#define INF 2123456789

int segTree[MAX_SIZE], N, M, height;

int min(int a, int b) { return (a < b ? a : b); }

void swap(int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

void init()
{
	for (register int i = (1 << height)-1; i > 0; i--) {
		segTree[i] = min(segTree[i * 2], segTree[i * 2 + 1]);
	}
}

int query(int left, int right, int curIdx, int curLeft, int curRight)
{
	if (left <= curLeft && curRight <= right) return segTree[curIdx];
	if (right < curLeft || curRight < left) return INF;

	int mid = (curLeft + curRight) /2;
	return min(query(left, right, curIdx * 2, curLeft, mid), query(left, right, curIdx * 2 + 1, mid + 1, curRight));
}

int main()
{
	scanf("%d %d", &N, &M);
	while ((1 << height) < N) height++;
	for (register int i = 0; i < (1 << height); i++) {
		segTree[(1 << height) + i] = INF;
	}

	for (register int i = 0; i < N; i++) {
		scanf("%d", &segTree[(1 << height) + i]);
	}

	init();

	int a, b;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &a, &b);
		if (a > b) swap(&a, &b);

		printf("%d\n", query(a, b, 1, 1, (1<<height)));
	}
	return 0;
}