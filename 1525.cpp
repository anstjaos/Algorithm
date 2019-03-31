#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}puzzle;

int map[3][3];
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };
puzzle zero;
puzzle before;
int minNum = 2123456789;

bool check(int arr[][3])
{
	int num = 1;
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (i == 2 && j == 2) return true;

			if (arr[i][j] == num)
			{
				num++;
			}
			else return false;
		}

	}

	return true;
}

void solve(int arr[][3], int cnt)
{
	if (zero.x == 2 && zero.y == 2)
	{
		if (check(arr) == true)
		{
			if (cnt < minNum) minNum = cnt;
			return;
		}
	}

	int temp[3][3];

	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			for (int k = 0; k < 3; k++)
			{
				temp[j][k] = arr[j][k];
				if (temp[j][k] == 0)
				{
					zero.x = j;
					zero.y = k;
				}
			}
		}
		int nextX = zero.x + dirX[i];
		int nextY = zero.y + dirY[i];

		if (nextX < 0 || nextY < 0 || nextX >= 3 || nextY >= 3) continue;

		if (before.x != zero.x && before.y != zero.y)
		{
			temp[zero.x][zero.y] = temp[nextX][nextY];
			temp[nextX][nextY] = 0;
			before.x = zero.x;
			before.y = zero.y;
			zero.x = nextX;
			zero.y = nextY;
			solve(temp, cnt + 1);
			
		}
	}
}

int main()
{
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == 0)
			{
				zero.x = i;
				zero.y = j;
			}
		}
	}
	before.x = zero.x;
	before.y = zero.y;
	
	solve(map, 0);
	
	if (minNum == 2123456789) cout << "-1" << endl;
	else cout << minNum << endl;
	return 0;
}