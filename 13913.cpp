#include <iostream>
using namespace std;

int queue[1000001], before[300001], check[300001];
int n, k;
int arr[300001];
bool visit[300001];
int front;
int rear;

void push(int item)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 1000001;
}

int top()
{
	int temp = (front + 1) % 1000001;
	return queue[temp];
}
void bfs(int start)
{
	visit[start] = true;
	push(start);
	while (front != rear)
	{
		int temp = top();
		if (temp == k) return;
		pop();

		if (visit[temp - 1] == false && temp - 1 >= 0)
		{
			push(temp - 1);
			visit[temp - 1] = true;
			before[temp - 1] = temp;
			arr[temp - 1] = arr[temp] + 1;
		}
		if (visit[temp + 1] == false && temp + 1 <= 100001)
		{
			push(temp + 1);
			visit[temp + 1] = true;
			before[temp + 1] = temp;
			arr[temp + 1] = arr[temp] + 1;
		}
		if (visit[temp * 2] == false && temp * 2 <= 100010)
		{
			push(temp * 2);
			visit[temp * 2] = true;
			before[temp * 2] = temp;
			arr[temp * 2] = arr[temp] + 1;
		}
	}
}

int main()
{
	front = -1;
	rear = -1;
	cin >> n >> k;
	arr[n] = 0;
	bfs(n);
	int result = arr[k];
	cout << arr[k] << endl;
	int cur = k;
	check[result] = k;
	result--;
	while (result != 0)
	{
		check[result] = before[cur];
		cur = before[cur];
		result--;
	}
	check[0] = n;

	result = arr[k];

	for (int i = 0; i <= result; i++)
	{
		cout << check[i] << " ";
	}
	cout << endl;
	return 0;
}