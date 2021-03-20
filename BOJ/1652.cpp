#include <iostream>
using namespace std;

#define WIDTH 1
#define HEIGHT 2

char map[101][101];
int mapSize, widthCnt, heightCnt;

void changeMap(int x, int y, int dir)
{
	if (dir == WIDTH)
	{
		int cnt = 0;
		for (int i = y; i < mapSize; i++)
		{
			if (map[x][i] == 'X' || map[x][i] == 'w') break;

			map[x][i] = 'w';
		}
	}
	else if (dir == HEIGHT)
	{
		int cnt = 0;
		for (int i = x; i < mapSize; i++)
		{
			if (map[i][y] == 'X' || map[i][y] == 'h') break;

			map[i][y] = 'h';
		}
	}
}

bool isSelterExist(int x, int y, int dir)
{
	if (dir == WIDTH)
	{
		int cnt = 0;
		for (int i = y; i < mapSize; i++)
		{
			if (map[x][i] == 'X' || map[x][i] == 'w') break;

			cnt++;
		}

		if (cnt >= 2) return true;
	}
	else if (dir == HEIGHT)
	{
		int cnt = 0;
		for (int i = x; i < mapSize; i++)
		{
			if (map[i][y] == 'X' || map[i][y] == 'h') break;

			cnt++;
		}

		if (cnt >= 2) return true;
	}
	return false;
}

void solve()
{
	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++)
		{
			if (map[i][j] != 'X' && map[i][j] != 'w')
			{
				if (isSelterExist(i, j, WIDTH))
				{
					widthCnt++;
					changeMap(i, j, WIDTH);
				}
			}
		}
	}

	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++)
		{
			if (map[i][j] != 'X' && map[i][j] != 'h')
			{
				if (isSelterExist(i, j, HEIGHT))
				{
					heightCnt++;
					changeMap(i, j, HEIGHT);
				}
			}
		}
	}
}

int main()
{
	cin >> mapSize;
	for (int i = 0; i < mapSize; i++) cin >> map[i];

	solve();
	cout << widthCnt << " " << heightCnt << "\n";
	return 0;
}