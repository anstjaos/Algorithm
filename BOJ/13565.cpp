#include <iostream>
#include <queue>
using namespace std;

typedef struct {
	int x, y;
}pt;
	
int row, col;
char map[1002][1002];
bool visit[1002][1002];
int dirX[4] = { 0,1,0,-1 }, dirY[4] = { 1,0,-1,0 };

bool bfs()
{
	queue<pt> q;
	for (int i = 0; i < col; i++)
	{
		if (map[0][i] == '0')
		{
			visit[0][i] = true;
			q.push({ 0,i });
		}
	}

	while (!q.empty())
	{
		pt cur = q.front();
		if (cur.x == row - 1) return true;
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (visit[nextX][nextY] == false && map[nextX][nextY] == '0')
			{
				visit[nextX][nextY] = true;
				q.push({ nextX,nextY });
			}
		}
	}
	return false;
}

int main()
{
	scanf("%d %d", &row, &col);
	for (int i = 0; i < row; i++) scanf("%s", map[i]);

	if (bfs()) printf("YES\n");
	else printf("NO\n");

	return 0;
}