#include <iostream>
using namespace std;

typedef struct {
	int initValue;
	int curValue;
	int count;
}job;

int testCase;
int N, K, W;
bool map[1002][1002];
job arr[1002];
int from, to;
int cost;

int queue[1000001];
int front, rear;

void push(int index)
{
	queue[++rear] = index;
}

bool isEmpty()
{
	if (rear == front) return true;
	else return false;
}

void pop()
{
	front++;
}

int getFront()
{
	return queue[front + 1];
}

void solve()
{
	int curIndex;
	for (int i = 1; i <= N; i++)
	{
		if (arr[i].count == 0)
		{
			curIndex = i;
			break;
		}
	}

	push(curIndex);

	while (!isEmpty())
	{
		curIndex = getFront();
		pop();

		for (int i = 1; i <= N; i++)
		{
			if (map[curIndex][i] == true)
			{
				arr[i].count--;
				if ((arr[i].initValue + arr[curIndex].curValue) > arr[i].curValue)
				{
					arr[i].curValue = (arr[i].initValue + arr[curIndex].curValue);
				}
				if (arr[i].count == 0) push(i);
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
		cin >> N >> K;
		for (int j = 1; j <= N; j++)
		{
			cin >> cost;
			arr[j].curValue = cost;
			arr[j].initValue = cost;
			arr[j].count = 0;
		}
		for (int j = 0; j < K; j++)
		{
			cin >> from >> to;
			map[from][to] = true;
			arr[to].count++;
		}
		cin >> W;

		solve();
		cout << arr[W].curValue << endl;

		for (int j = 1; j <= N; j++)
		{
			for (int k = 1; k <= N; k++) map[j][k] = false;
		}
	}
}