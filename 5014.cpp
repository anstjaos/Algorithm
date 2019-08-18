#include <iostream>
using namespace std;

bool visit[1000001];
int queue[1000001], buliding[1000001], front, rear;
int total, cur, desti, up, down;

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

void bfs(int start)
{
	int cur;
	front = rear = -1;
	push(start);
	buliding[start] = 0;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (cur == desti) return;
		if (visit[cur] == true) continue;
		visit[cur] = true;

		if (cur + up <= total && visit[cur + up] == false)
		{
			buliding[cur + up] = buliding[cur] + 1;
			push(cur + up);
		}
		if (cur - down > 0 && visit[cur - down] == false)
		{
			buliding[cur - down] = buliding[cur] + 1;
			push(cur - down);
		}
	}
}

int main()
{
	cin >> total >> cur >> desti >> up >> down;
	bfs(cur);

	if (desti == cur)
	{
		cout << "0" << endl;
		return 0;
	}

	if (buliding[desti] == 0)
	{
		cout << "use the stairs" << endl;
	}
	else cout << buliding[desti] << endl;
	return 0;
}