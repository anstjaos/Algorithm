#include <stdio.h>
#define INF 2123456789

typedef struct {
	int x;
	int y;
}Pt;

int min(int a, int b) { return (a < b ? a : b); }

typedef struct Queue{
	Pt queue[3000];
	int front, rear;

	Queue() {
		front = -1;
		rear = -1;
	}

	void push(Pt item)
	{
		rear = (rear + 1) % 3000;
		queue[rear] = item;
	}

	Pt pop()
	{
		front = (front + 1) % 3000;
		return queue[front];
	}

	bool isEmpty() {
		return front == rear;
	}
}Queue;

int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 }, row, col;
char map[52][52];
Pt car[105], parking[105];
int carIdx, parkingIdx, parkDist[105][105], pred[105];
bool visit[105];

void bfs(int idx)
{
	Queue q;
	q.push(car[idx]);
	int dist[52][52] = { -1, };
	for (register int i = 0; i < 52; i++) {
		for (register int j = 0; j < 52; j++) dist[i][j] = -1;
	}
	dist[car[idx].x][car[idx].y] = 0;

	while (!q.isEmpty())
	{
		Pt cur = q.pop();

		for (register int i = 0; i < 4; i++) {
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
			if (dist[nextX][nextY] != -1 || map[nextX][nextY] == 'X') continue;

			dist[nextX][nextY] = dist[cur.x][cur.y] + 1;
			q.push({ nextX, nextY });
		}
	}

	for (register int i = 0; i < parkingIdx; i++) {
		parkDist[idx][i] = dist[parking[i].x][parking[i].y];
	}
}

bool dfs(int cur, int max)
{
	if (cur == -1) return true;

	for (register int i = 0; i < parkingIdx; i++) {
		if (visit[i] || parkDist[cur][i] > max || parkDist[cur][i] == -1) continue;
		visit[i] = true;

		if (dfs(pred[i], max))
		{
			pred[i] = cur;
			return true;
		}
	}
	return false;
}

int networkFlow(int max)
{
	int ret = 0;
	for (register int i = 0; i < carIdx; i++) {
		for (register int j = 0; j < 105; j++) visit[j] = false;
		if (dfs(i, max)) {
			ret += 1;
		}
	}
	return ret;
}

int main()
{
	scanf("%d %d", &row, &col);
	for (register int i = 0; i < row; i++) {
		for (register int j = 0; j < col; j++) {
			scanf(" %c", &map[i][j]);
			if (map[i][j] == 'C') car[carIdx++] = { i,j };
			else if (map[i][j] == 'P') parking[parkingIdx++] = { i,j };
		}
	}
	if (carIdx == 0) {
		printf("0\n");
		return 0;
	}

	for (register int i = 0; i < carIdx; i++)
	{
		bfs(i);
	}
	
	int low = 1, high = row * col + 1;
	int ans = INF;
	while (low <= high)
	{
		int mid = (low + high) / 2;
		for (register int i = 0; i < 105; i++) pred[i] = -1;
		if (networkFlow(mid) == carIdx)
		{
			ans = min(ans, mid);
			high = mid - 1;
		}
		else low = mid + 1;
	}

	if (ans == INF) printf("-1\n");
	else printf("%d\n", ans);
	return 0;
}