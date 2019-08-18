#include <iostream>
using namespace std;

bool visit[35][35];
int N;
double arr[4], result = 0.0;
int dirX[4] = { 0,0,1,-1 }, dirY[4] = { 1,-1,0,0 };

void dfs(int x, int y, int cnt, double percent)
{
	visit[x][y] = true;

	if (cnt == N)
	{
		visit[x][y] = false;
		result += percent;
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int nextX = x+ dirX[i];
		int nextY = y+dirY[i];

		if (visit[nextX][nextY] == false)
		{
			dfs(nextX, nextY, cnt + 1, percent*arr[i]);
			visit[nextX][nextY] = false;
		}
	}
}

int main()
{
	cin >> N;

	for (int i = 0; i < 4; i++)
	{
		cin >> arr[i];
		arr[i] /= 100.0;
	}

	dfs(15, 15, 0, 1.0);
	printf("%.10lf\n", result);
	return 0;
}