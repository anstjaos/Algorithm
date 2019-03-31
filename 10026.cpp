#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}mv;

int N, front, rear;
mv queue[100001];
char map[101][101], temp[101][101];
int result = 0;
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

void bfsC(int x, int y, char color, char arr[101][101])
{
	front = rear = -1;
	push({ x,y });

	mv cur;
	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX > N || nextY > N) continue;

			if (color == 'G' || color == 'R')
			{
				if (arr[nextX][nextY] == 'G' || arr[nextX][nextY] == 'R')
				{
					arr[nextX][nextY] = 'X';
					push({ nextX,nextY });
				}
			}
			else if (color == 'B')
			{
				if (arr[nextX][nextY] == 'B')
				{
					arr[nextX][nextY] = 'X';
					push({ nextX,nextY });
				}
			}
		}
	}
	
}

void bfs(int x, int y, char color, char arr[101][101])
{
	front = rear = -1;
	push({ x,y });

	mv cur;
	while (front != rear)
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX > N || nextY > N) continue;

			if (color == arr[nextX][nextY] )
			{
				
					arr[nextX][nextY] = 'X';
					push({ nextX,nextY });
			
			}
			
		}
	}
}

int main()
{
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> map[i];
	}


	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++) temp[i][j] = map[i][j];
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (map[i][j] != 'X')
			{
				bfs(i, j, map[i][j], map);
				result++;
			}
		}
	}
	cout << result << " ";
	result = 0;
	

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (temp[i][j] != 'X')
			{
				bfsC(i, j, temp[i][j], temp);
				result++;
			}
		}
	}
	cout << result << endl;
	return 0;
}