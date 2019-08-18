#include <iostream>
using namespace std;

typedef struct {
	int x, y;
}mv;
int map[301][301], row, col, check[301][301], front ,rear, cnt = 0;
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
bool visit[301][301];
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

void checkIceMelt(mv cur)
{
	int cnt = 0;
	for (int i = 0; i < 4; i++)
	{
		int nextX = cur.x + dirX[i];
		int nextY = cur.y + dirY[i];

		if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

		if (map[nextX][nextY] == 0) cnt++;
	}
	check[cur.x][cur.y] = cnt;
}

void meltIce()
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (check[i][j] != 0)
			{
				if (map[i][j] - check[i][j] < 0)
				{
					map[i][j] = 0;
				}
				else if (map[i][j] - check[i][j] >= 0) map[i][j] = map[i][j] - check[i][j];

				check[i][j] = 0;
			}
		}
	}
}

void bfs(mv start)
{
	front = rear = -1;
	push(start);
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;

			if (map[nextX][nextY] != 0 && visit[nextX][nextY] == false)
			{
				visit[nextX][nextY] = true;
				push({ nextX,nextY });
			}
		}
	}
}

int main()
{
	cin >> row >> col;
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++) cin >> map[i][j];
	}

	while (1)
	{
		bool allMelt = true;
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (map[i][j] != 0)
				{
					allMelt = false;
					checkIceMelt({ i,j });// 얼마나 녹는지 체크
				}
			}
		}

		if (allMelt == true)
		{
			cnt = 0;
			break;
		}

		cnt++;
		meltIce();// 얼음 녹이기 함수
		
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++) visit[i][j] = false;
		}
		int iceCnt = 0;
		// 얼음 덩어리 체크
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (map[i][j] != 0 && visit[i][j] == false)
				{
					bfs({ i,j });
					iceCnt++;
				}
			}
		}

		if (iceCnt >= 2) break;
	}

	cout << cnt << '\n';
	return 0;
}