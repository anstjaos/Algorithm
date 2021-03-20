#include <iostream>
using namespace std;

typedef struct a{
	int index;
	a* next;

	a() {}
	a(int i_index, a* i_next)
	{
		index = i_index;
		next = i_next;
	}
}node;

node* nodeArr[32003];
int inEdge[32003];
int n, m, from, to;
int queue[1000001], front, rear;
bool visit[32003];

void push(int index)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = index;
}

void pop()
{
	front = (front + 1) % 1000001;
}

int getFront()
{
	int temp = (front + 1) % 1000001;
	return queue[temp];
}

void getNode(int from, int to)
{
	if (nodeArr[from] == 0)
	{
		nodeArr[from] = new a(to, NULL);
	}
	else
	{
		nodeArr[from] = new a(to, nodeArr[from]);
	}
}

void solve()
{
	front = rear = -1;

	for (int i = 1; i <= n; i++)
	{
		if (inEdge[i] == 0) push(i);
	}

	int cur;
	while (front != rear)
	{
		cur = getFront();
		pop();

		cout << cur << " ";
		visit[cur] = true;

		node* ptr = nodeArr[cur];

		while (ptr != 0)
		{
			inEdge[ptr->index]--;
			if (inEdge[ptr->index] == 0) push(ptr->index);
			ptr = ptr->next;
		}
	}

	for (int i = 1; i <= n; i++)
	{
		if (visit[i] == false)
		{
			cout << i << " ";
		}
	}
	cout << '\n';
}

void deleteNode()
{
	for (int i = 1; i <= n; i++)
	{
		node* ptr = nodeArr[i];

		while (ptr != 0)
		{
			node* temp = ptr;
			ptr = ptr->next;
			delete temp;
		}
	}
}

int main()
{
	cin >> n >> m;

	for (int i = 0; i < m; i++)
	{
		cin >> from >> to;
		getNode(from, to);
		inEdge[to]++;
	}
	solve();
	deleteNode();

	return 0;
}