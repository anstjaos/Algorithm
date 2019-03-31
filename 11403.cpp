#include <iostream>
using namespace std;

int map[101][101];
int result[101][101];
int mapSize;
int queue[100001];
int front, rear;

void push(int index)
{
	rear = (rear + 1) % 100001;
	queue[rear] = index;
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

bool isEmpty()
{
	if (front == rear) return true;
	else return false;
}

void solve(int start)
{
	int cur;
	rear = -1;
	front = -1;
	for (int i = 0; i < mapSize; i++)
	{
		if (map[start][i] == 1) push(i);
	}
	
	bool check[101] = { 0, };

	while (!isEmpty())
	{
		cur = getFront();
		result[start][cur] = 1;
		check[cur] = true;
		pop();
		for (int i = 0; i < mapSize; i++)
		{
			if (map[cur][i] == 1 && check[i] == false)
			{
				push(i);
				check[i] = true;
				result[start][i] = 1;
			}
		}
	}
}

int main()
{
	cin >> mapSize;
	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++) cin >> map[i][j];
	}

	for (int i = 0; i < mapSize; i++)
	{
		solve(i);
	}

	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++) cout << result[i][j] << " ";

		cout << endl;
	}
}