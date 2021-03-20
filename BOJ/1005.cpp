//#include <iostream>
//using namespace std;
//
//typedef struct {
//	int initValue;
//	int curValue;
//	int count;
//}job;
//
//int testCase;
//int N, K, W;
//bool map[1002][1002];
//job arr[1002];
//int from, to;
//int cost;
//
//int queue[1000001];
//int front, rear;
//
//void push(int index)
//{
//	queue[++rear] = index;
//}
//
//bool isEmpty()
//{
//	if (rear == front) return true;
//	else return false;
//}
//
//void pop()
//{
//	front++;
//}
//
//int getFront()
//{
//	return queue[front + 1];
//}
//
//void solve()
//{
//	int curIndex;
//	for (int i = 1; i <= N; i++)
//	{
//		if (arr[i].count == 0)
//		{
//			curIndex = i;
//			break;
//		}
//	}
//
//	push(curIndex);
//
//	while (!isEmpty())
//	{
//		curIndex = getFront();
//		pop();
//
//		for (int i = 1; i <= N; i++)
//		{
//			if (map[curIndex][i] == true)
//			{
//				arr[i].count--;
//				if ((arr[i].initValue + arr[curIndex].curValue) > arr[i].curValue)
//				{
//					arr[i].curValue = (arr[i].initValue + arr[curIndex].curValue);
//				}
//				if (arr[i].count == 0) push(i);
//			}
//		}
//	}
//}
//
//int main()
//{
//	cin >> testCase;
//	for (int i = 0; i < testCase; i++)
//	{
//		front = -1;
//		rear = -1;
//		cin >> N >> K;
//		for (int j = 1; j <= N; j++)
//		{
//			cin >> cost;
//			arr[j].curValue = cost;
//			arr[j].initValue = cost;
//			arr[j].count = 0;
//		}
//		for (int j = 0; j < K; j++)
//		{
//			cin >> from >> to;
//			map[from][to] = true;
//			arr[to].count++;
//		}
//		cin >> W;
//
//		solve();
//		cout << arr[W].curValue << endl;
//
//		for (int j = 1; j <= N; j++)
//		{
//			for (int k = 1; k <= N; k++) map[j][k] = false;
//		}
//	}
//}

#include <stdio.h>
using namespace std;

#define MAX_SIZE 1005
#define QUEUE_SIZE 100005

int T, N, K, X, Y, W;
int map[MAX_SIZE][MAX_SIZE], inEdge[MAX_SIZE], buildTime[MAX_SIZE];
long long result[MAX_SIZE];
int queue[QUEUE_SIZE], front, rear;
bool inQ[MAX_SIZE];

void push(int item)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % QUEUE_SIZE;
	return queue[front];
}

void init()
{
	scanf("%d %d", &N, &K);
	for (register int i = 1; i <= N; i++){
		scanf("%d", buildTime + i);
		inEdge[i] = 0;
		result[i] = 0;
		for (register int j = 1; j <= N; j++) map[i][j] = 0;
	}

	for (register int i = 0; i < K; i++) {
		scanf("%d %d", &X, &Y);
		map[X][Y] = 1;
		inEdge[Y]++;
	}
	scanf("%d", &W);
}

void solve()
{
	front = rear = -1;
	for (register int i = 1; i <= N; i++) {
		inQ[i] = false;
		if (inEdge[i] == 0) {
			push(i);
			inQ[i] = true;
			result[i] = buildTime[i];
		}
	}

	while (front != rear)
	{
		int cur = pop();
		inQ[cur] = false;
		
		for (register int i = 1; i <= N; i++) {
			if (map[cur][i] == 0) continue;

			if (result[i] < result[cur] + buildTime[i]) {
				result[i] = result[cur] + buildTime[i];

				if (i == W) continue;
				if (inQ[i] == false) {
					inQ[i] = true;
					push(i);
				}
			}
		}
	}
}

int main()
{
	scanf("%d", &T);
	while (T--)
	{
		init();
		solve();
		printf("%lld\n", result[W]);
	}
	return 0;
}