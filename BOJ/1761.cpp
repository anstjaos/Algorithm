#include <stdio.h>
#include <vector>
using namespace std;
#define MAX_VERTEX 40001

typedef struct {
	int idx;
	int cost;
}Edge;

Edge parent[MAX_VERTEX];
int depth[MAX_VERTEX], N, M;
vector<Edge> edge[MAX_VERTEX];

int queue[MAX_VERTEX], front, rear;

void push(int item)
{
	rear = (rear + 1) % MAX_VERTEX;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % MAX_VERTEX;
	return queue[front];
}

void makeTree()
{
	front = rear = -1;
	push(1);
	depth[1] = 1;

	while (front != rear)
	{
		int cur = pop();

		for (Edge next : edge[cur])
		{
			if (depth[next.idx] != 0) continue;

			parent[next.idx] = { cur, next.cost };
			depth[next.idx] = depth[cur] + 1;
			push(next.idx);
		}
	}
}

int findLCA(int a, int b)
{
	int ret = 0;
	if (depth[a] < depth[b]) {
		int temp = a;
		a = b;
		b = temp;
	}

	while (depth[a] != depth[b]) {
		ret += parent[a].cost;
		a = parent[a].idx;
	}

	if (a == b) return ret;

	while (a != b)
	{
		ret += parent[a].cost;
		a = parent[a].idx;

		ret += parent[b].cost;
		b = parent[b].idx;
	}

	return ret;
}

int main()
{
	scanf("%d", &N);
	int a, b, c;
	for (register int i = 0; i < N-1; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		edge[a].push_back({ b,c });
		edge[b].push_back({ a,c });
	}

	makeTree();
	scanf("%d", &M);
	for (register int i = 0; i < M; i++)
	{
		scanf("%d %d", &a, &b);
		printf("%d\n", findLCA(a, b));
	}

	return 0;
}