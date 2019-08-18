#include <iostream>
using namespace std;

int A, B, N, M, arr[100001];
int queue[1000001], front, rear;

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

void bfs()
{
	front = rear = -1;
	push(N);
	int cur;
	
	int next;
	while (front != rear)
	{
		cur = getFront();
		pop();

		if (cur == M) return;

		next = cur - 1;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
		next = cur + 1;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
		next = cur + A;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
		next = cur - A;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
		next = cur + B;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
		next = cur - B;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
		next = cur * A;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
		next = cur * B;
		if (next > 0 && next <= 100000 && arr[next] == 0)
		{
			arr[next] = arr[cur] + 1;
			push(next);
		}
	}
}

int main()
{
	cin >> A >> B >> N >> M;
	bfs();
	cout << arr[M] << endl;
	return 0;
}