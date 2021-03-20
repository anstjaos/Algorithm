#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}mv;
int map[101][101], front, rear, N ,minNum = 101, maxNum = -1, maxCnt, result;
mv queue[100001];
bool visit[101][101];
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0, 1, 0 ,-1 };

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

void init()
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++) visit[i][j] = false;
	}
}

void bfs(int x, int y,int min)
{
	front = rear = -1;
	push({ x,y });
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (visit[cur.x][cur.y] == true) continue;
		visit[cur.x][cur.y] = true;

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;

			if (visit[nextX][nextY] == false && map[nextX][nextY] > min)
			{
				push({ nextX,nextY });
			}
		}
	}
}
int main()
{
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cin >> map[i][j];
			if (map[i][j] < minNum) minNum = map[i][j];
			if (map[i][j] > maxNum) maxNum = map[i][j];
		}
	}

	if (minNum == maxNum)
	{
		cout << "1" << endl;
		return 0;
	}
	for (int i = minNum; i < maxNum; i++)
	{
		result = 0;
		init();
		for (int j = 0; j < N; j++)
		{
			for (int k = 0; k < N; k++)
			{
				if (map[j][k] > i && visit[j][k] == false)
				{
					bfs(j, k,i);
					result++;
				}
			}
		}

		if (maxCnt < result) maxCnt = result;
	}

	cout << maxCnt << endl;
	return 0;

}