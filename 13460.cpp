#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}ball;

char map[20][20];
int row, col;
int minNum = 212345678;
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };

void solve(char arr[20][20], int dir, int cnt)
{
	if (cnt >= 11 || cnt > minNum) return;

	char temp[20][20];
	ball redBall;
	ball blueBall;

	for (int i = 0; i < 4; i++)
	{
		if (dir == (i + 2) % 4) continue;

		for (int j = 0; j < row; j++)
		{
			for (int k = 0; k < col; k++)
			{
				temp[j][k] = arr[j][k];
				if (arr[j][k] == 'R')
				{
					redBall.x = j;
					redBall.y = k;
				}
				else if (arr[j][k] == 'B')
				{
					blueBall.x = j;
					blueBall.y = k;
				}
			}
		}

		bool redOut = false;
		bool blueOut = false;
		bool redFirst = false;
		switch (i)
		{
		case 0:
			if ((redBall.x < blueBall.x)) redFirst = true;
			break;
		case 1:
			if ((redBall.y > blueBall.y)) redFirst = true;
			break;
		case 2:
			if ((redBall.x > blueBall.x)) redFirst = true;
			break;
		case 3:
			if ((redBall.y < blueBall.y)) redFirst = true;
			break;
		}

		if (redFirst == true)
		{
			while (1)
			{
				if (temp[redBall.x + dirX[i]][redBall.y + dirY[i]] == '.')
				{
					temp[redBall.x + dirX[i]][redBall.y + dirY[i]] = 'R';
					temp[redBall.x][redBall.y] = '.';
				}
				else if (temp[redBall.x + dirX[i]][redBall.y + dirY[i]] == 'O')
				{
					temp[redBall.x][redBall.y] = '.';
					redOut = true;
					break;
				}
				else break;

				redBall.x = redBall.x + dirX[i];
				redBall.y = redBall.y + dirY[i];
			}
			while (1)
			{
				if (temp[blueBall.x + dirX[i]][blueBall.y + dirY[i]] == '.')
				{
					temp[blueBall.x + dirX[i]][blueBall.y + dirY[i]] = 'B';
					temp[blueBall.x][blueBall.y] = '.';
				}
				else if (temp[blueBall.x + dirX[i]][blueBall.y + dirY[i]] == 'O')
				{
					temp[blueBall.x][blueBall.y] = '.';
					blueOut = true;
					break;
				}
				else break;

				blueBall.x = blueBall.x + dirX[i];
				blueBall.y = blueBall.y + dirY[i];

			}
		}
		else
		{
			while (1)
			{
				if (temp[blueBall.x + dirX[i]][blueBall.y + dirY[i]] == '.')
				{
					temp[blueBall.x + dirX[i]][blueBall.y + dirY[i]] = 'B';
					temp[blueBall.x][blueBall.y] = '.';
				}
				else if (temp[blueBall.x + dirX[i]][blueBall.y + dirY[i]] == 'O')
				{
					temp[blueBall.x][blueBall.y] = '.';
					blueOut = true;
					break;
				}
				else break;

				blueBall.x = blueBall.x + dirX[i];
				blueBall.y = blueBall.y + dirY[i];
			}
			while (1)
			{
				if (temp[redBall.x + dirX[i]][redBall.y + dirY[i]] == '.')
				{
					temp[redBall.x + dirX[i]][redBall.y + dirY[i]] = 'R';
					temp[redBall.x][redBall.y] = '.';

				}
				else if (temp[redBall.x + dirX[i]][redBall.y + dirY[i]] == 'O')
				{
					temp[redBall.x][redBall.y] = '.';
					redOut = true;
					break;
				}
				else break;

				redBall.x = redBall.x + dirX[i];
				redBall.y = redBall.y + dirY[i];
			}
		}
	
		if (blueOut == true) return;
		else if (redOut == true && blueOut == false)
		{
			if (cnt < minNum) minNum = cnt;

			return;
		}

		solve(temp, i,cnt + 1);
	}
}

int main()
{
	cin >> row >> col;

	for (int i = 0; i < row; i++)
	{
		cin >> map[i];

	}

	solve(map, 5,1);
	if (minNum == 212345678) cout << -1 << endl;
	else cout << minNum << endl;

	return 0;
}