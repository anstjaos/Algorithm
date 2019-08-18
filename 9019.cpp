#include <iostream>
using namespace std;

typedef struct {
	char change[10001];
}ch;

ch arr[10001];
int testCase, queue[100001], front, rear;
bool visit[10001];
int num, toChange;

void push(int item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

int getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

bool isEmpty() { return (front == rear); }

int strlen1(char *target)
{
	int index = 0;

	while (target[index] != '\0') index++;
	return index;
}

void strcat1(int target, char *origin, char input)
{
	int len = strlen1(origin);
	for (int i = 0; i < len; i++) arr[target].change[i] = origin[i];
	
	arr[target].change[len] = input;
}

void bfs(int start)
{
	front = rear = -1;
	visit[start] = true;
	push(start);
	
	while (!isEmpty())
	{
		int cur = getFront();
		if (cur == toChange) return;
		
		pop();
		// D
		if (visit[(cur * 2) % 10000] == false)
		{
			push((cur * 2) % 10000);
			strcat1((cur * 2) % 10000, arr[cur].change,'D');
			visit[(cur * 2) % 10000] = true;
		}
		// S
		if (cur != 0 && visit[cur - 1] == false)
		{
			push(cur - 1);
			strcat1(cur - 1, arr[cur].change, 'S');
			visit[cur-1] = true;
		}
		else if (cur == 0 && visit[9999] == false)
		{
			push(9999);
			strcat1(9999, arr[cur].change, 'S');
			visit[cur - 1] = true;
		}
		// L
		if (cur >= 1000)
		{
			int temp = (cur - (cur / 1000 * 1000)) * 10 + (cur / 1000);
			if (visit[temp] == false)
			{
				push(temp);
				strcat1(temp, arr[cur].change, 'L');
				visit[temp] = true;
			}
		}
		else
		{
			if (visit[cur * 10] == false)
			{
				push(cur * 10);
				strcat1(cur * 10, arr[cur].change, 'L');
				visit[cur * 10] = true;
			}
		}
		// R
		int temp = cur % 10;
		temp = temp * 1000 + (cur / 10);
		if (visit[temp] == false)
		{
			push(temp);
			strcat1(temp, arr[cur].change, 'R');
			visit[temp] = true;
		}
	}
}

void init()
{
	for (int i = 0; i < 10001; i++)
	{
		visit[i] = false;
		int len = strlen1(arr[i].change);
		for (int j = 0; j < len; j++) arr[i].change[j] = '\0';
	}
}
int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> num >> toChange;
		init();

		bfs(num);
		int len = strlen1(arr[toChange].change);

		for (int i = 0; i < len; i++) cout << arr[toChange].change[i];
		cout << endl;
	}
	return 0;
}