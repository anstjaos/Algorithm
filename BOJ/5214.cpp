#include <iostream>
using namespace std;

typedef struct a {
	int tubeNum;
	a* next;
}node;

int tube[1001][1001], N, K , M;
node* tubeLink[100001];
int visit[100001], queue[100001], front, rear;
bool check[100001], tubeCheck[1001];

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

void input(int index, int tube)
{
	if (tubeLink[index] == 0) tubeLink[index] = new node({ tube,0 });
	else
	{
		node *temp = tubeLink[index];
		tubeLink[index] = new node({ tube, temp });
	}
}

void reset(int index)
{
	node* ptr = tubeLink[index];

	while (ptr != 0)
	{
		node* temp = ptr;
		ptr = ptr->next;
		delete temp;
	}
}

void bfs()
{
	front = rear = -1;
	push(1);
	visit[1] = 1;
	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (cur == N) return;
		if (check[cur] == true) continue;
		check[cur] = true;
		node *curPtr = tubeLink[cur];

		while (curPtr != 0)
		{
			if (tubeCheck[curPtr->tubeNum] == true)
			{
				curPtr = curPtr->next;
				continue;
			}

			for (int i = 0; i < K; i++)
			{
				int temp = tube[curPtr->tubeNum][i];
				if (temp == cur) continue;

				if (visit[temp] == 0)
				{
					visit[temp] = visit[cur] + 1;
					push(temp);
				}
				else if (visit[temp] > visit[cur] + 1)
				{
					visit[temp] = visit[cur] + 1;
					push(temp);
				}
			}
			tubeCheck[curPtr->tubeNum] = true;
			curPtr = curPtr->next;
		}
	}
}

int main()
{
	cin >> N >> K >> M;

	for (int i = 1; i <= M; i++)
	{
		for (int j = 0; j < K; j++)
		{
			cin >> tube[i][j];
			input(tube[i][j], i);
		}
	}
	bfs();

	for (int i = 1; i <= N; i++)
	{
		reset(i);
	}
	
	if (visit[N] == 0) cout << "-1" << '\n';
	else cout << visit[N] << '\n';
	return 0;
}