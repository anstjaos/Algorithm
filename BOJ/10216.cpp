#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
	int r;
}pt;

pt arr[3005];
int tc, N, queue[900001], front, rear;
bool visit[3001], group[3001][3001];

bool isEmpty() { return front == rear; }

void push(int item)
{
	rear = (rear + 1) % 900001;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % 900001;
	return queue[front];
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d", &N);
		int cnt = 0;
		for (register int i = 0; i < N; i++) {
			scanf("%d %d %d", &arr[i].x, &arr[i].y, &arr[i].r);
			visit[i] = false;
	
			for (register int j = 0; j < N; j++) group[i][j] = false;
		}

		for (register int i = 0; i < N; i++) {
			for (register int j = 0; j < N; j++) {
				if (i == j) continue;

				int dist = (arr[i].x - arr[j].x) * (arr[i].x - arr[j].x) + (arr[i].y - arr[j].y) * (arr[i].y - arr[j].y);
				int bound = (arr[i].r + arr[j].r) * (arr[i].r + arr[j].r);

				if (dist <= bound)
				{
					group[i][j] = true;
					group[j][i] = true;
				}
			}
		}

		for (register int i = 0; i < N; i++) {
			if (!visit[i])
			{
				front = rear = -1;
				push(i);
				visit[i] = true;
				cnt++;

				while (!isEmpty())
				{
					int cur = pop();

					for (register int j = 0; j < N; j++) {
						if (group[cur][j] == false) continue;

						if (!visit[j])
						{
							push(j);
							visit[j] = true;
						}
					}
				}
				
			}
		}

		printf("%d\n", cnt);
	}

	return 0;
}