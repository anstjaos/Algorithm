#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
	bool breakWall;
}mv;
char map[1001][1001];
int row, col, result = 2123456789;
mv queue[100001];
int temp[1001][1001];
int front, rear;
bool visit[1001][1001][2];
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };

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

void bfs()
{

	
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			visit[i][j][0] = false;
			visit[i][j][1] = false;
			temp[i][j] = 0;
		}
	}

	front = rear = -1;
	push({ 0,0,false });
	temp[0][0] = 1;
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();
		if (cur.x == row - 1 && cur.y == col - 1) break;
		if (visit[cur.x][cur.y][cur.breakWall] == true) continue;
		visit[cur.x][cur.y][cur.breakWall] = true;

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

			if (visit[nextX][nextY][cur.breakWall] == false && map[nextX][nextY] == '0')
			{
				if(cur.breakWall == true) push({ nextX,nextY,true });
				else push({ nextX,nextY,false });

				temp[nextX][nextY] = temp[cur.x][cur.y] + 1;
			}
			else if (visit[nextX][nextY][cur.breakWall] == false && map[nextX][nextY] == '1' && cur.breakWall == false)
			{
				push({ nextX,nextY, true });
				temp[nextX][nextY] = temp[cur.x][cur.y] + 1;
			}
		}
	}

	if (temp[row - 1][col - 1] != 0)
	{
		if (temp[row - 1][col - 1] < result) result = temp[row - 1][col - 1];
	}
}

int main()
{
	cin >> row >> col;
	for (int i = 0; i < row; i++) cin >> map[i];

	bfs();

	if (result == 2123456789) cout << "-1" << endl;
	else cout << result << endl;

	return 0;
}