#include <iostream>
#include <queue>
using namespace std;

typedef struct {
	int x, y;
}mv;

queue<mv> q;
char map[1001][1001];
int fire[1001][1001], escape[1001][1001];
bool visit[1001][1001];
mv start, fireStart;
int row, col, dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };

void checkFire()
{
	while (!q.empty())
	{

		mv cur = q.front();
		q.pop();
		visit[cur.x][cur.y] == true;
		for (int j = 0; j < 4; j++)
		{
			int nextX = cur.x + dirX[j];
			int nextY = cur.y + dirY[j];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col || visit[nextX][nextY] == true) continue;

			if (map[nextX][nextY] != '#' && (fire[nextX][nextY] == 0 || fire[nextX][nextY] > fire[cur.x][cur.y]+1))
			{
				fire[nextX][nextY] = fire[cur.x][cur.y] + 1;
				q.push({ nextX,nextY });
			}
		}

	}
}

int checkEscape()
{
	queue<mv> que;

	que.push(start);

	while (!que.empty())
	{
		mv cur = que.front();
		que.pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) return escape[cur.x][cur.y] + 1;
			if ((nextX == start.x && nextY == start.y)) continue;

			if (map[nextX][nextY] == '.' && fire[nextX][nextY] > escape[cur.x][cur.y] + 1)
			{
				if(escape[nextX][nextY] == 0) escape[nextX][nextY] = escape[cur.x][cur.y] + 1;
				else if (escape[nextX][nextY] > escape[cur.x][cur.y] + 1)
				{
					escape[nextX][nextY] = escape[cur.x][cur.y] + 1;
				}
				else if (escape[nextX][nextY] <= escape[cur.x][cur.y] + 1) continue;
				
				
				que.push({ nextX, nextY });
			}
		}
	}
	return -1;
}

int main()
{
	cin >> row >> col;

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == 'J')
			{
				start.x = i;
				start.y = j;
			}
			else if (map[i][j] == 'F')
			{
				q.push({ i,j });
			}
		}
	}
	checkFire();
	int result = checkEscape();

	if (result == -1) cout << "IMPOSSIBLE" << endl;
	else cout << result << endl;

	return 0;
}