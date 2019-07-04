#include <cstdio>
#include <algorithm>
#define MAX_SIZE 1000001
typedef struct {
	int value;
	int index;
}Node;

Node nodeArr[MAX_SIZE];
int N, height, segTree[MAX_SIZE *4 + 1];

int max(int a, int b) { return (a > b ? a : b); }

bool cmp(const Node& a, const Node& b)
{
	if (a.value == b.value) return a.index > b.index;
	return a.value < b.value;
}

int query(int left, int right, int nodeNum, int curLeft, int curRight)
{
	if (right < curLeft || curRight < left) return 0;
	if (left <= curLeft && curRight <= right) return segTree[nodeNum];

	int mid = (curLeft + curRight) / 2;
	return max(query(left, right, nodeNum * 2, curLeft, mid), query(left, right, nodeNum * 2 + 1, mid + 1, curRight));
}

void update(int index)
{
	while (index > 1)
	{
		index /= 2;
		segTree[index] = max(segTree[index * 2], segTree[index * 2 + 1]);
	}
}

int main()
{
	scanf("%d", &N);
	while ((1 << height) < N) height++;
	for (register int i = 0; i < N; i++)
	{
		scanf("%d", &nodeArr[i].value);
		nodeArr[i].index = i;
	}

	std::sort(nodeArr, nodeArr + N, cmp);
	for (register int i = 0; i < N; i++)
	{
		segTree[(1 << height) + nodeArr[i].index] = query(0, nodeArr[i].index, 1, 0, (1<< height)-1) + 1;
		update((1 << height) + nodeArr[i].index);
	}
	printf("%d\n", segTree[1]);
	return 0;
}