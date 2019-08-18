#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}virus;

virus queue[20000000];
int front = -1;
int rear = -1;
int row;
int col;
int arr[11][11];
int nextX[4] = { -1,0,1,0 };
int nextY[4] = { 0,1,0,-1 };
int maxCnt = -1;

void push(virus v)
{
	rear = (rear + 1) % 20000000;
	queue[rear] = v;
}

virus pop()
{
	front = (front + 1) % 20000000;
	virus temp = queue[front];
	return temp;
}

bool isEmpty()
{
	return (front == rear);
}

void checkVirus(int a[][11])
{
	int cnt = 0;
	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			if (a[i][j] == 0) cnt++;
		}
	}
	if (cnt > maxCnt) maxCnt = cnt;
}

void spreadVirus(int a[][11])
{
	front = rear = -1;
	int temp[11][11];
	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			temp[i][j] = a[i][j];
			if (a[i][j] == 2)
			{
				push({ i,j });
			}
		}
	}

	while (!isEmpty())
	{
		virus cur = pop();

		for (int i = 0; i < 4; i++)
		{
			int nX = cur.x + nextX[i];
			int nY = cur.y + nextY[i];

			if (nX < 1 || nY < 1 ||nX > row || nY > col) continue;
			if (temp[nX][nY] == 0)
			{
				temp[nX][nY] = 2;

				push({ nX , nY });
			}
		}
	}

	checkVirus(temp);
}

void solve(int a[][11], int x, int y, int count)
{
	if (count == 3)
	{
		spreadVirus(a);
		return;
	}

	int temp[11][11];

	for (int i = 0; i < 11; i++)
	{
		for (int j = 0; j < 11; j++) temp[i][j] = a[i][j];
	}

	
	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			if (temp[i][j] == 0)
			{
				temp[i][j] = 1;
				solve(temp, i, j, count + 1);
				temp[i][j] = 0;
			}
		}
	}
}

int main()
{
	cin >> row >> col;
	for (int i = 0; i < 11; i++)
	{
		for (int j = 0; j < 11; j++) arr[i][j] = -1;
	}

	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++) cin >> arr[i][j];
	}

	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			if (arr[i][j] == 0)
			{
				arr[i][j] = 1;
				solve(arr, i, j, 1);
				arr[i][j] = 0;
			}
		}
	}


	cout << maxCnt << endl;
	return 0;
}