#include <iostream>
using namespace std;

typedef struct {
	int x, y;
}mv;

char map[251][251];
int front, rear, sheepCnt = 0, wolfCnt = 0;
int row, col, dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
bool visit[251][251];
mv queue[100001];

void push(mv item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

mv getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

void bfs(int x, int y)
{
	front = rear = -1;
	push({ x,y });
	mv cur;
	visit[x][y] = true;
	int sheep = 0, wolf = 0;

	if (map[x][y] == 'v') wolf++;
	else if (map[x][y] == 'o') sheep++;

	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (visit[nextX][nextY] == true || map[nextX][nextY] == '#') continue;
			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

			if (map[nextX][nextY] == 'v') wolf++;
			if (map[nextX][nextY] == 'o') sheep++;

			push({ nextX, nextY });
			visit[nextX][nextY] = true;
		}
	}

	if (wolf >= sheep) wolfCnt = wolfCnt + wolf;
	else if(wolf < sheep) sheepCnt = sheepCnt + sheep;
}

int main()
{
	cin >> row >> col;

	for (int i = 0; i < row; i++)
	{
		cin >> map[i];
	}

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (map[i][j] != '#' && visit[i][j] == false) bfs(i, j);
		}
	}

	cout << sheepCnt << " " << wolfCnt << '\n';
	return 0;
}