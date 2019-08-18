#include <iostream>
#include <queue>
using namespace std;

#define SNAKE 1
#define APPLE 2
typedef struct {
	int x;
	int y;
}Point;

int N, cnt, dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
int curDir,  nextDir[10002], sec;
char tempDir;
Point temp, cur;
int map[105][105];

int main()
{
	scanf("%d", &N);
	queue<Point> q;
	map[1][1] = SNAKE;
	//saveDir[1][1] = 1;
	cur.x = 1;
	cur.y = 1;
	curDir = 1;

	q.push(cur);
	scanf("%d", &cnt);
	for (register int i = 0; i < cnt; i++) {
		scanf("%d %d", &temp.x, &temp.y);
		map[temp.x][temp.y] = APPLE;
	}

	scanf("%d", &cnt);
	for (register int i = 0; i < cnt; i++) {
		scanf("%d %c", &temp.x, &tempDir);
		if (tempDir == 'L') nextDir[temp.x] = -1;
		else if (tempDir == 'D') nextDir[temp.x] = 1;
	}

	while (1)
	{
		bool eat = false;
		sec++;
		int nextX = cur.x + dirX[curDir];
		int nextY = cur.y + dirY[curDir];

		if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) break;
		if (map[nextX][nextY] == SNAKE) break;

		if (map[nextX][nextY] == APPLE) eat = true;
		//saveDir[cur.x][cur.y] = curDir;
		map[nextX][nextY] = SNAKE;
		cur.x = nextX;
		cur.y = nextY;
		q.push(cur);
		if (eat == false) {
			Point t = q.front();

			map[t.x][t.y] = 0;
			q.pop();
		}
		curDir = (curDir + nextDir[sec] + 4) % 4;
	}

	printf("%d\n", sec);
	return 0;
}