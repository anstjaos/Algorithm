#include <iostream>
#include <queue>
using namespace std;

#define SIZE 10001
int N, M;
int maxComputer = -1, result[10001], resultCnt;
//int queue[SIZE], front, rear;
bool visit[10001];

typedef struct a{
	int num;
	a* next;

	a() {}
	a(int i_num, a* i_next) {
		num = i_num;
		next = i_next;
	}
}node;

node* trust[10001];
//
//void push(int item)
//{
//	rear = (rear + 1) % SIZE;
//	queue[rear] = item;
//}
//
//int pop()
//{
//	front = (front + 1) % SIZE;
//	return queue[front];
//}
//
//bool isEmpty() { return front == rear; }

void bfs(int start)
{
	for (register int i = 1; i <= N; i++) visit[i] = false;

	int sum = 0;
	//front = rear = -1;
	queue<int> q;
	q.push(start);
	visit[start] = true;

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		sum++;
		node* ptr = trust[cur];
		while (ptr != NULL)
		{
			int next = ptr->num;
			if (!visit[next])
			{
				q.push(next);
				visit[next] = true;
			}
			ptr = ptr->next;
		}
	}

	if (sum == maxComputer)
	{
		result[resultCnt++] = start;
	}
	else if (sum > maxComputer)
	{
		resultCnt = 0;
		result[resultCnt++] = start;
		maxComputer = sum;
	}
}


int main()
{
	int a, b;
	scanf("%d %d", &N, &M);
	for (register int i = 1; i <= N; i++) trust[i] = NULL;

	for (register int i = 0; i < M; i++)
	{
		scanf("%d %d", &a, &b);
		node* ptr = trust[b];
		
		if (ptr == NULL) trust[b] = new node(a, 0);
		else trust[b] = new node(a, trust[b]);
	}

	for (register int i = 1; i <= N; i++) bfs(i);

	for (register int i = 0; i < resultCnt; i++) {
		printf("%d ", result[i]);
	}

	for (register int i = 1; i <= N; i++) {
		node* ptr = trust[i];
		node* prePtr = trust[i];

		while (ptr != NULL) {
			prePtr = ptr;
			ptr = ptr->next;
			delete prePtr;
		}
	}
	printf("\n");
	return 0;
}