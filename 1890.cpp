<<<<<<< HEAD
#include <stdio.h>

int N, arr[130][130];
long long dp[130][130];

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%d", &arr[i][j]);
	}

	if (arr[0][0] == 0) {
		printf("0\n");
		return 0;
	}
	dp[0][0] = 1;
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {
			if (dp[i][j] == 0 || arr[i][j] == 0) continue;
			dp[i + arr[i][j]][j] += dp[i][j];
			dp[i][j + arr[i][j]] += dp[i][j];
		}
	}

	printf("%lld\n", dp[N - 1][N - 1]);
=======
#include <iostream>
using namespace std;

typedef struct {
	int x, y;
}mv;

int map[101][101];
long long dp[101][101];
int mapSize, front, rear;
mv queue[100001];

void push(mv item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

mv getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

void bfs(int x, int y)
{
	front = rear = -1;
	push({ x,y });
	mv cur;

	while(front != rear)
	{ 
		cur = getFront();
		pop();
		
		if (map[cur.x][cur.y] == 0) continue;
		if (cur.x + map[cur.x][cur.y] <= mapSize)
		{
			dp[cur.x + map[cur.x][cur.y]][cur.y] += dp[cur.x][cur.y];
			push({ cur.x + map[cur.x][cur.y] , cur.y });
		}
		if (cur.y + map[cur.x][cur.y] <= mapSize)
		{
			dp[cur.x][cur.y + map[cur.x][cur.y]] += dp[cur.x][cur.y];
			push({ cur.x, cur.y + map[cur.x][cur.y] });
		}
	}
}

int main()
{
	cin >> mapSize;
	for (int i = 1; i <= mapSize; i++)
	{
		for (int j = 1; j <= mapSize; j++) cin >> map[i][j];
	}
	dp[1][1] = 1;
	//bfs(1,1);

	for (int i = 1; i <= mapSize; i++)
	{
		for (int j = 1; j <= mapSize; j++)
		{
			if (dp[i][j] == 0 || (i == mapSize && j == mapSize)) continue;
			int down = i + map[i][j];
			int right = j + map[i][j];

			if (down <= mapSize)
			{
				dp[down][j] += dp[i][j];
			}
			if (right <= mapSize) dp[i][right] += dp[i][j];
		}
	}
	cout << dp[mapSize][mapSize] << endl;

>>>>>>> 7e54d4f313862c06a87f7dfb04c956c0f7648aa7
	return 0;
}