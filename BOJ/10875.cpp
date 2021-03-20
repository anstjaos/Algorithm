#include <iostream>
using namespace std;

bool plusX[400000001];
bool plusY[100000001];
bool minusX[100000001];
bool minusY[100000001];

int arrSize, N, nextTime, result = 0;
char dir;
bool dead = false;
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };

int main()
{
	cin >> arrSize >> N;
	int curX = 0;
	int curY = 0, curDir = 2;
	int nextX, nextY;
	for (int i = 0; i < N; i++)
	{
		cin >> nextTime >> dir;

		for (int j = 0; j < nextTime; j++)
		{
			nextX = curX + dirX[curDir];
			nextY = curY + dirY[curDir];

			if (nextX < -arrSize || nextY < -arrSize || nextX > arrSize || nextY > arrSize)
			{
				dead = true;
				break;
			}

			if (nextX >= 0 && nextY >= 0)
			{
				if (plusX[nextX] == true && plusY[nextY] == true)
				{
					dead = true;
					break;
				}
				plusX[nextX] = true;
				plusY[nextY] = true;
			}
			else if (nextX < 0 && nextY >= 0)
			{
				if (minusX[-nextX] == true && plusY[nextY] == true)
				{
					dead = true;
					break;
				}
				minusX[-nextX] = true;
				plusY[nextY] = true;
			}
			else if (nextX >= 0 && nextY < 0)
			{
				if (plusX[nextX] == true && minusY[-nextY] == true)
				{
					dead = true;
					break;
				}
				plusX[nextX] = true;
				minusY[-nextY] = true;
			}
			else if (nextX < 0 && nextY < 0)
			{
				if (minusX[-nextX] == true && minusY[-nextY] == true)
				{
					dead = true;
					break;
				}
				minusX[-nextX] = true;
				minusY[-nextY] = true;
			}
			result++;
			curX = nextX;
			curY = nextY;
		}
		if (dead == true) break;

		if (dir == 'L')
		{
			curDir = (curDir + 4 - 1) % 4;
		}
		else if (dir == 'R') curDir = (curDir + 1) % 4;
		
	}
	cout << result << endl;
	return 0;
}