#include <cstdio>
#include <algorithm>
#define MAX_SIZE 100001

typedef struct {
	int value;
	int index;
}Node;

int N, segTree[MAX_SIZE * 4], height;
Node arr[MAX_SIZE];

int max(int a, int b) { return (a > b ? a : b); }
bool cmp(const Node& a, const Node& b)
{
	if (a.value == b.value) return a.index > b.index;
	return a.value < b.value;
}

int query(int left, int right, int curNode, int curLeft, int curRight)
{
	if (right < curLeft || curRight < left) return 0;
	if (left <= curLeft && curRight <= right) return segTree[curNode];

	int mid = (curLeft + curRight) / 2;
	return max(query(left, right, curNode * 2, curLeft, mid), query(left, right, curNode * 2 + 1, mid + 1, curRight));
}

void update(int index)
{
	while (index > 1) {
		index /= 2;
		segTree[index] = max(segTree[index * 2], segTree[index * 2 + 1]);
	}
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++)
	{
		scanf("%d", &arr[i].value);
		arr[i].index = i;
	}
	while ((1 << height) < N) height++;

	std::sort(arr, arr + N, cmp);
	for (register int i = 0; i < N; i++)
	{
		segTree[(1 << height) + arr[i].index] = query(0, arr[i].index, 1, 0, (1 << height) - 1) + 1;
		update((1 << height) + arr[i].index);
	}
	printf("%d\n", N-segTree[1]);
	return 0;
}