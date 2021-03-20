#include <iostream>
#include <algorithm>
using namespace std;

typedef struct {
	int x;
	int y;
}pt;

pt queue[3000];
int front, rear;
int N, L, R, map[51][51], cnt;
bool visit[51][51];

int dirX[4] = { 1,0,-1,0};
int dirY[4] = { 0,1,0,-1};

void push(pt item)
{
	rear = (rear + 1) % 3000;
	queue[rear] = item;
}

pt pop()
{
	front = (front + 1) % 3000;
	return queue[front];
}

bool isEmpty() { return front == rear; }

void init()
{
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) visit[i][j] = false;
	}
}

bool bfs(pt start)
{
	pt visitArr[2500];
	int arrCnt = 0;
	int sum = 0, count = 0;

	front = rear = -1;
	push(start);
	visit[start.x][start.y] = true;

	count += 1;
	sum += map[start.x][start.y];
	visitArr[arrCnt++] = { start.x, start.y };

	while (!isEmpty())
	{
		pt cur = pop();

		for (int i = 0; i < 4; i++) {
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			if (visit[nextX][nextY]) continue;

			if (L <= abs(map[nextX][nextY] - map[cur.x][cur.y]) && abs(map[nextX][nextY] - map[cur.x][cur.y]) <= R)
			{
				count += 1;
				sum += map[nextX][nextY];
				visitArr[arrCnt++] = { nextX, nextY};
				visit[nextX][nextY] = true;
				push({ nextX, nextY });
			}
		}
	}

	if (count == 1) return false;

	sum = sum / count;
	for (register int i = 0; i < arrCnt; i++) {
		pt cur = visitArr[i];
		map[cur.x][cur.y] = sum;
	}
	return true;
}

int main()
{
	scanf("%d %d %d", &N, &L, &R);

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%d", &map[i][j]);
	}

	while (1)
	{
		init();
		bool flag = false;
		for (register int i = 0; i < N; i++) {
			for (register int j = 0; j < N; j++) {
				if (!visit[i][j])
				{
					for (register int k = 0; k < 4; k++) {
						int nextX = i + dirX[k];
						int nextY = j + dirY[k];

						if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
						if (visit[nextX][nextY]) continue;

						if (L <= abs(map[nextX][nextY] - map[i][j]) && abs(map[nextX][nextY] - map[i][j]) <= R)
						{
							flag |= bfs({ i,j });
							break;
						}
					}
				}
			}
		}

		if (flag == false) break;
		cnt++;
	}

	printf("%d\n", cnt);
	return 0;
}