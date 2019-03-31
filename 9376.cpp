#include <iostream>
using namespace std;

typedef struct {
	int x, y, mvCnt;
}mv;

int row, col, front, rear, testCase;
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
int prisoner1Arr[105][105], prisoner2Arr[105][105], outsideArr[105][105];
bool visit[105][105];
char map[105][105];
mv queue[100001], prisoner1, prisoner2;

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

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = queue[(left + right) / 2].mvCnt;

	while (leftIndex <= rightIndex)
	{
		while (queue[leftIndex].mvCnt < pivot) leftIndex++;
		while (queue[rightIndex].mvCnt > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(queue[leftIndex], queue[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

void bfs(int arr[105][105], mv start)
{
	front = rear = -1;
	push(start);
	mv cur;

	for (int i = 0; i <= row + 1; i++)
	{
		for (int j = 0; j <= col + 1; j++) arr[i][j] = -1;
	}

	arr[start.x][start.y] = 0;
	while (front != rear)
	{
		quickSort(front+1, rear);
		cur = getFront();
		pop();

	/*	if (visit[cur.x][cur.y] == true) continue;
		visit[cur.x][cur.y] = true;
*/
		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX > row +1|| nextY > col+1) continue;
			if (map[nextX][nextY] == '*' ) continue;

			if (map[nextX][nextY] == '#')
			{
				if (arr[nextX][nextY] == -1)
				{
					arr[nextX][nextY] = arr[cur.x][cur.y] + 1;
					push({ nextX,nextY, arr[nextX][nextY] });
				}
				else if (arr[nextX][nextY] > arr[cur.x][cur.y] + 1)
				{
					arr[nextX][nextY] = arr[cur.x][cur.y ]+ 1;
					push({ nextX,nextY, arr[nextX][nextY] });
				}
			}
			else if(map[nextX][nextY] == '$' || map[nextX][nextY] =='.')
			{
				if (arr[nextX][nextY] == -1 || arr[nextX][nextY] > arr[cur.x][cur.y])
				{
					arr[nextX][nextY] = arr[cur.x][cur.y];
					push({ nextX,nextY, cur.mvCnt });
				}
			
			}
		}
	}
}

void init()
{
	prisoner1.x = -1;
	cin >> row >> col;
	for (int i = 0; i <= col + 1; i++)
	{
		map[0][i] = '.';
		map[row + 1][i] = '.';
	}
	for (int i = 0; i <= row + 1; i++)
	{
		map[i][0] = '.';
		map[i][col + 1] = '.';
	}
	for (int j = 1; j <= row; j++)
	{
		for(int k = 1; k<= col; k++) cin >> map[j][k];
	}
	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{

			if (map[i][j] == '$')
			{
				if (prisoner1.x == -1)
				{
					prisoner1.x = i;
					prisoner1.y = j;
					prisoner1.mvCnt = 0;
				}
				else
				{
					prisoner2.x = i;
					prisoner2.y = j;
					prisoner2.mvCnt = 0;
				}
			}
		}
	}

}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		init();
		int result = 2123456789;
		bfs(prisoner1Arr,prisoner1);
		bfs(prisoner2Arr, prisoner2);
		bfs(outsideArr, { 0,0,0 });

		for (int j = 0; j <= row+1; j++)
		{
			for (int k = 0; k <= col+1; k++)
			{
				if (map[j][k] == '*') continue;

				int temp = prisoner1Arr[j][k] + prisoner2Arr[j][k] + outsideArr[j][k];
				if (map[j][k] == '#')
				{
					temp = temp - 2;
				}

				if (temp < result) result = temp;
			}
		}
		cout << result << endl;
	}
	return 0;
}