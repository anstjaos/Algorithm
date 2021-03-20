#include <iostream>
#include <string>
using namespace std;

int dirX[4] = { 0,-1,0,1 }, dirY[4] = { 1,0,-1,0 };
int M, n, num, curDir;
string order;
int map[1001][1001];
int curX = 0, curY = 0;
bool out = false;

int main()
{
	scanf("%d%d", &M, &n);
	for (int i = 0; i < n; i++)
	{
		cin >> order >> num;
		
		if (order == "MOVE")
		{
			curX = curX + dirX[curDir] * num;
			curY = curY + dirY[curDir] * num;
			
			if (curX < 0 || curY <0 || curX >M || curY > M)
			{
				out = true;
				break;
			}
		}
		else if (order == "TURN")
		{
			if (num == 0) curDir = (curDir - 1 + 4) % 4;
			else curDir = (curDir + 1 + 4) % 4;
		}
	}

	if (out == true) printf("-1\n");
	else printf("%d %d\n", curY, curX);

	return 0;
}