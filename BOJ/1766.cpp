#include <iostream>
#include <queue>
#include <functional>
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

node* nodeArr[32003];
int n, m, inedge[32003];
bool visit[32003];
//
//void push(int item)
//{
//	rear = (rear + 1) % 1000001;
//	queue[rear] = item;
//} 
//
//void pop()
//{
//	front = (front + 1) % 1000001;
//}
//
//int getFront()
//{
//	int temp = (front + 1) % 1000001;
//	return queue[temp];
//}
//
//void quickSort(int left, int right)
//{
//	int leftIndex = left;
//	int rightIndex = right;
//	int pivot = queue[(left + right) / 2];
//
//	while (leftIndex <= rightIndex)
//	{
//		while (queue[leftIndex] < pivot) leftIndex++;
//		while (queue[rightIndex] > pivot) rightIndex--;
//
//		if (leftIndex <= rightIndex)
//		{
//			swap(queue[leftIndex], queue[rightIndex]);
//			leftIndex++;
//			rightIndex--;
//		}
//	}
//
//	if (left < rightIndex) quickSort(left, rightIndex);
//	if (leftIndex < right) quickSort(leftIndex, right);
//}

void getNode(int from, int to)
{
	if (nodeArr[from] == 0) nodeArr[from] = new a(to, 0);
	else
	{
		nodeArr[from] = new a(to, nodeArr[from]);
	}
}

void solve()
{

	priority_queue<int,vector<int>,greater<int>> q;

	for (int i = 1; i <= n; i++)
	{
		if (inedge[i] == 0) q.push(i);
	}

	int cur;

	while (!q.empty())
	{
		cur = q.top();
		q.pop();

		cout << cur << " ";
		visit[cur] = true;
		node* ptr = nodeArr[cur];

		while (ptr != 0)
		{
			inedge[ptr->index]--;
			if (inedge[ptr->index] == 0) q.push(ptr->index);
			ptr = ptr->next;
		}
	}

	for (int i = 1; i <= n; i++)
	{
		if (visit[i] == false) cout << i << " ";
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
	int from, to;
	cin >> n >> m;

	for (int i = 0; i < m; i++)
	{
		cin >> from >> to;
		getNode(from, to);
		inedge[to]++;
	}

	solve();
	deleteNode();

	return 0;
}