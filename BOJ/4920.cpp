#include <iostream>
using namespace std;

int dirX[13][3] = { {0,0,0}, {1,2,3}, {0,1,1}, {-1,-1,-2}, {0,0,1}, {1,2,2}, {1,1,1}, {-1,-2,-2}, {0,0,1}, {1,2,1}, {0,0,-1}, {-1,-2,-1}, {0,1,1} };
int dirY[13][3] = { {1,2,3}, {0,0,0}, {1,1,2}, {0,-1,-1}, {1,2,2}, {0,0,-1}, {0,1,2}, {0,0,1}, {1,2,1}, {0,0,-1}, {-1,-2,-1}, {0,0,1}, {1,0,1 } };

int map[101][101], mapSize;
long long maxResult;

void init()
{
	maxResult = -98765432123456789;
	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++) cin >> map[i][j];
	}
}

long long getResult(int x, int y)
{
	long long result = -98765432123456789;
	for (int i = 0; i < 13; i++)
	{
		long long temp = map[x][y];
		for (int j = 0; j < 3; j++)
		{
			int nextX = x + dirX[i][j];
			int nextY = y + dirY[i][j];

			if (nextX < 0 || nextY < 0 || nextX >= mapSize || nextY >= mapSize)
			{
				temp = -98765432123456789;
				break;
			}

			temp = temp + map[nextX][nextY];
		}

		if (result < temp) result = temp;
	}

	return result;
}

void solve()
{
	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++)
		{
			long long temp = getResult(i, j);
			if (maxResult < temp)
			{
				maxResult = temp;
			}
		}
	}
}

int main()
{
	int testCase = 0;
	while (1)
	{
		cin >> mapSize;
		testCase++;
		if (mapSize == 0) break;

		init();
		solve();
		cout << testCase << ". ";
		
		cout << maxResult << '\n';
	}
	return 0;
}