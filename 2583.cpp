#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}pt;

int M, N, K;
bool map[103][103];
int dirX[4] = { -1,0,1,0 };
int dirY[4] = { 0,1,0,-1 };
int result[101];
int resultIndex = 0;
pt queue[1000001];
int front, rear;

int max(int a, int b) { return (a > b ? a : b); }
int min(int a, int b) { return (a < b ? a : b); }

void push(pt index)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = index;
}

void pop()
{
	front = (front + 1) % 1000001;
}

pt getFront()
{
	int temp = (front + 1) % 1000001;
	return queue[temp];
}

bool isEmpty() { return (front == rear); }

void color(pt temp, pt temp1)
{
	int minX = min(temp.x, temp1.x);
	int maxX = max(temp.x, temp1.x);
	int minY = min(temp.y, temp1.y);
	int maxY = max(temp.y, temp1.y);

	for (int i = minX; i < maxX ; i++)
	{
		for (int j = minY; j < maxY ; j++) map[i][j] = true;
	}
}

void bfs(pt start)
{
	front = rear = -1;
	push(start);
	pt cur;
	int cnt = 1;
	map[start.x][start.y] = true;
	while (!isEmpty())
	{
		cur = getFront();
		pop();

		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || map[nextX][nextY] == true) continue;

			map[nextX][nextY] = true;
			cnt++;
			push({ nextX, nextY });
		}
	}

	result[resultIndex++] = cnt;
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = result[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (result[leftIndex] < pivot) leftIndex++;
		while (result[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(result[leftIndex], result[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	cin >> M >> N >> K;
	for (int i = 0; i < K; i++)
	{
		pt temp, temp1;

		cin >> temp.x >> temp.y >> temp1.x >> temp1.y;
		color(temp, temp1);
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] == false) bfs({ i,j });
		}
	}

	cout << resultIndex << endl;
	if (resultIndex != 0)
	{
		quickSort(0, resultIndex-1);
		for (int i = 0; i < resultIndex; i++)
		{
			cout << result[i] << " ";
		}
		cout << endl;
	}
	return 0;
}