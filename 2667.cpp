#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}loc;

char map[27][27];
bool check[27][27];
loc queue[1000001];
int front, rear;
int mapSize;
int arr[3000];
int arrCnt;
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };

bool isEmpty()
{
	if (front == rear) return true;
	else return false;
}

void push(loc item)
{
	queue[++rear] = item;
}

void pop()
{
	front++;
}

loc getFront()
{
	return queue[front + 1];
}

void init()
{
	front = rear = -1;
	arrCnt = 0;

	cin >> mapSize;
	for (int i = 0; i <= mapSize +1; i++)
	{
		map[0][i] = '0';
		map[i][0] = '0';
		map[mapSize+1][i] = '0';
		map[i][mapSize+1] = '0';
	}

	for (int i = 1; i <= mapSize; i++)
	{
		for (int j = 1; j <= mapSize; j++) cin >> map[i][j];
	}
}

int bfs(int x, int y)
{
	loc temp;
	temp.x = x;
	temp.y = y;
	check[x][y] = true;
	push(temp);
	int cnt = 1;
	while (!isEmpty())
	{
		temp = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = temp.x + dirX[i];
			int nextY = temp.y + dirY[i];

			if (map[nextX][nextY] == '1' && check[nextX][nextY] == false)
			{
				check[nextX][nextY] = true;
				loc item;
				item.x = nextX;
				item.y = nextY;
				push(item);
				cnt++;
			}
		}
	}
	return cnt;
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = arr[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex] < pivot) leftIndex++;
		while (arr[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(arr[leftIndex], arr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}
int main()
{
	init();
	int result;
	for (int i = 1; i <= mapSize; i++)
	{
		for (int j = 1; j <= mapSize; j++)
		{
			if (map[i][j] == '1' && check[i][j] == false)
			{
				result = bfs(i, j);
				arr[arrCnt] = result;
				arrCnt++;
			}
		}
	}
	quickSort(0, arrCnt - 1);
	cout << arrCnt << endl;
	for (int i = 0; i < arrCnt; i++) cout << arr[i] << endl;
}