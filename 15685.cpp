#include <iostream>
using namespace std;

bool visit[102][102];
int dirX[4] = { 1,0,-1,0 }, dirY[4] = { 0,-1,0,1 };
int generation[2049], N, startX, startY, dir, g;

void move()
{
	visit[startX][startY] = true;
	int curX = startX;
	int curY = startY;
	for (int i = 0; i < (1 << g); i++)
	{
		curX = curX + dirX[(generation[i] + dir) % 4];
		curY = curY + dirY[(generation[i] + dir) % 4];
		visit[curX][curY] = true;
	}
}

int check()
{
	int cnt = 0;
	for (int i = 0; i <= 100; i++)
	{
		for (int j = 0; j <= 100; j++)
		{
			if (visit[i][j] == true && visit[i + 1][j] == true
				&& visit[i][j + 1] == true && visit[i + 1][j + 1] == true) cnt++;
		}
	}

	return cnt;
}

int main()
{
	generation[0] = 0;
	generation[1] = 1;
	for (int i = 2; i <= 10; i++)
	{
		for (int j = 0; j < (1 << i); j++)
		{
			generation[(1 << (i - 1)) + j] = (generation[(1 << (i - 1)) - j - 1] + 1) % 4;
		}
	}

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> startX >> startY >> dir >> g;
		move();
	}

	int result = check();
	cout << result << "\n";
	return 0;
}