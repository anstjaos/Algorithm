#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
	int cnt;
}knight;

int testCase;
int mapSize;
knight queue[100001];
int front, rear;
knight start, desti;
int dirX[8] = { -2,-1,1,2,2,1,-1,-2 };
int dirY[8] = { 1,2,2,1,-1,-2,-2,-1 };
int result;
bool check[301][301];

void push(knight item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

knight getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

bool isEmpty()
{
	if (rear == front) return true;
	else return false;
}

void solve()
{
	push(start);
	knight cur;

	while (!isEmpty())
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 8; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX == desti.x && nextY == desti.y)
			{
				result = cur.cnt + 1;
				return;
			}
			if (nextX >= 0 && nextY >= 0 && nextX < mapSize && nextY < mapSize
				&& check[nextX][nextY] == false)
			{
				knight next;
				next.x = nextX;
				next.y = nextY;
				next.cnt = cur.cnt + 1;
				check[nextX][nextY] = true;
				push(next);
			}
		}
	}
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		front = -1;
		rear = -1;
		cin >> mapSize;
		cin >> start.x >> start.y;
		cin >> desti.x >> desti.y;
		start.cnt = 0;

		for (int i = 0; i < mapSize; i++)
		{
			for (int j = 0; j < mapSize; j++) check[i][j] = false;
		}
		if (start.x == desti.x && start.y == desti.y)
		{
			cout << "0" << endl;
			continue;
		}
		solve();
		cout << result << endl;
	}
}