#include <iostream>
using namespace std;

typedef struct {
	int x, y, cnt;
}mv;

mv queue[100001];
int K, row, col, front, rear;
int map[201][201], check[201][201];
bool visit[201][201][31];
int horseX[8] = { -2,-2,-1,1,2,2,1,-1 }, dirX[4] = { -1,0,1,0 };
int horseY[8] = { -1,1,2,2,1,-1,-2,-2 }, dirY[4] = { 0,1,0,-1 };

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

int bfs()
{
	front = rear = -1;
	push({ 0,0,0 });
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (cur.x == row - 1 && cur.y == col - 1) return check[cur.x][cur.y];

		if (cur.cnt < K)
		{
			for (int i = 0; i < 8; i++)
			{
				int nextX = cur.x + horseX[i];
				int nextY = cur.y + horseY[i];

				if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

				if (visit[nextX][nextY][cur.cnt+1] == false && map[nextX][nextY] != 1)
				{
					visit[nextX][nextY][cur.cnt+1] = true;

					check[nextX][nextY] = check[cur.x][cur.y] + 1;
			

					push({ nextX, nextY,cur.cnt+1 });
				}
			}
		}

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];
			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

			if (visit[nextX][nextY][cur.cnt] == false &&  map[nextX][nextY] != 1)
			{
				visit[nextX][nextY][cur.cnt] = true;
				check[nextX][nextY] = check[cur.x][cur.y] + 1;
			
				push({ nextX, nextY,cur.cnt });
			}
		}
	}
	return -1;
}
int main()
{
	cin >> K >> col >> row;

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++) cin >> map[i][j];
	}

	int result = bfs();

	cout << result << '\n';

	return 0;
}