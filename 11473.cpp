#include <iostream>
#include <vector>
using namespace std;

int queue[50005];
int front, rear;
vector<int> arr[50005];
int parent[50005], depth[50005];
int a, b, n, m;

void push(int item)
{
	queue[++rear] = item;
}

int pop()
{
	return queue[++front];
}

bool isEmpty()
{
	return front == rear;
}

void bfs(int start)
{
	push(start);
	parent[start] = 1;

	while (!isEmpty())
	{
		int cur = pop();
		int size = arr[cur].size();

		for (int i = 0; i < size; i++)
		{
			if (parent[arr[cur][i]] == 0)
			{
				parent[arr[cur][i]] = cur;
				depth[arr[cur][i]] = depth[cur] + 1;
				push(arr[cur][i]);
			}
		}
	}
}

void setSameDepth(int d, int &num)
{
	while (depth[num] != d)
	{
		num = parent[num];
	}
}

int solve(int num1, int num2)
{
	if (depth[num1] != depth[num2])
	{
		if (depth[num1] > depth[num2]) setSameDepth(depth[num2], num1);
		else setSameDepth(depth[num1], num2);
	}

	while (num1 != num2)
	{
		num1 = parent[num1];
		num2 = parent[num2];
	}
	
	return num1;
}

int main()
{
	scanf("%d", &n);
	for (int i = 0; i < n-1; i++)
	{
		scanf("%d %d", &a, &b);
		arr[a].push_back(b);
		arr[b].push_back(a);
	}

	bfs(1);
	scanf("%d", &m);

	for (int i = 0; i < m; i++)
	{
		scanf("%d %d", &a, &b);
		printf("%d\n", solve(a, b));
	}

	return 0;
}