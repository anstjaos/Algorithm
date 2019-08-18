#include <cstdio>
#include <algorithm>
#define MAX_SIZE 100001

typedef struct {
	int value;
	int index;
}Node;

int N, segTree[MAX_SIZE * 4], height;
Node input[MAX_SIZE];

int max(int a, int b) { return (a > b ? a : b); }

bool cmp(const Node& a, const Node& b)
{
	if (a.value == b.value) return a.index > b.index;
	return a.value < b.value;
}

void init()
{
	for (register int i = 0; i < (1 << (height + 1)); i++)
	{
		segTree[i] = 0;
	}

	for (register int i = 0; i < N; i++)
	{
		scanf("%d", &input[i].value);
		input[i].index = i;
	}
	std::sort(input, input + N, cmp);
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
	while (index > 1)
	{
		index /= 2;
		segTree[index] = max(segTree[index*2], segTree[index * 2 + 1]);
	}
}

int main()
{
	while (scanf("%d", &N) != EOF)
	{
		height = 0;
		while ((1 << height) < N) height++;
		init();
		for (register int i = 0; i < N; i++)
		{
			segTree[(1 << height) + input[i].index] = query(0, input[i].index, 1, 0, (1 << height) - 1) + 1;
			update((1 << height) + input[i].index);
		}
		printf("%d\n", segTree[1]);
	}
	return 0;
}