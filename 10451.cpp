#include <iostream>
using namespace std;

int testCase;
int arrSize;
int arr[1001];
bool visit[1001];
int queue[1000001];
int front, rear;
int cnt;
void push(int item)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = item;
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

bool isEmpty()
{
	return (front == rear);
}

void solve(int start)
{
	push(start);
	visit[start] = true;
	int cur;

	while (!isEmpty())
	{
		cur = getFront();
		pop();

		if (visit[arr[cur]] == false)
		{
			push(arr[cur]);
			visit[arr[cur]] = true;
 		}
	}
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> arrSize;
		for (int j = 1; j <= arrSize; j++)
		{
			cin >> arr[j];
			visit[j] = false;
		}
		front = rear = -1;
		cnt = 0;
		for (int j = 1; j <= arrSize; j++)
		{
			if (visit[j] == false)
			{
				solve(j);
				cnt++;
			}
		}
		cout << cnt << '\n';
	}
	return 0;
}