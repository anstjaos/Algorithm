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

	return 0;
}