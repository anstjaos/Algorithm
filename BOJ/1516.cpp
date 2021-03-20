#include <iostream>
using namespace std;

typedef struct a {
	int index;
	a* next;
	a() {}
	a(int i_index, a* i_next)
	{
		index = i_index;
		next = i_next;
	}
}node;

node* nodeArr[502];
int initArr[502], result[502], N, initValue, temp;
int queue[1002], inEdge[502], front, rear;

int max(int a, int b) { return (a > b ? a : b); }
void push(int index)
{
	rear = (rear + 1) % 1002;
	queue[rear] = index;
}

void pop()
{
	front = (front + 1) % 1002;
}

int getFront()
{
	int temp = (front + 1) % 1002;
	return queue[temp];
}

void getNode(int from, int to)
{
	if (nodeArr[from] == 0) nodeArr[from] = new a(to, 0);
	else nodeArr[from] = new a(to, nodeArr[from]);
}

void solve()
{
	front = rear = -1;

	for (int i = 1; i <= N; i++)
	{
		if (inEdge[i] == 0) push(i);
	}
	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		result[cur] = result[cur] + initArr[cur];
		node* ptr = nodeArr[cur];
	
		while (ptr != 0)
		{
			inEdge[ptr->index]--;
			if (inEdge[ptr->index] == 0) push(ptr->index);

			result[ptr->index] = max(result[ptr->index], result[cur]);
			ptr = ptr->next;
		}
	}
}

void deleteNode()
{
	for (int i = 1; i <= N; i++)
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
	cin >> N;
	for (int i = 1; i <= N; i++)
	{
		cin >> initValue;
		initArr[i] = initValue;

		while (1)
		{
			cin >> temp;
			if (temp == -1) break;

			getNode(temp, i);
			inEdge[i]++;

		}
	}

	solve();
	deleteNode();
	for (int i = 1; i <= N; i++)
	{
		if (result[i] != 0) cout << result[i] << '\n';
		else cout << initArr[i] << '\n';
	}
	return 0;
}