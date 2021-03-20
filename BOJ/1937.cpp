#include <iostream>
using namespace std;

typedef struct {
	int x, y, value;
}mv;

int forest[501][501], mapSize, dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };
int check[501][501], maxResult = -1, front, rear;
mv queue[250001];

void push(mv item)
{
	rear = (rear + 1) % 250001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 250001;
}

mv getFront()
{
	int temp = (front + 1) % 250001;
	return queue[temp];
}

int max(int a, int b) { return (a > b ? a : b); }

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = queue[(left + right) / 2].value;

	while (leftIndex <= rightIndex)
	{
		while (queue[leftIndex].value > pivot) leftIndex++;
		while (queue[rightIndex].value < pivot) rightIndex--;

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

void solve()
{
	mv cur;
	while (front != rear)
	{
		cur = getFront();
		pop();
		int cnt = 1;
		for (int i = 0; i < 4; i++)
		{
			int nextX = cur.x + dirX[i];
			int nextY = cur.y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= mapSize || nextY >= mapSize) continue;

			if (forest[nextX][nextY] > forest[cur.x][cur.y])
			{
				cnt = max(cnt, check[nextX][nextY] + check[cur.x][cur.y]);
			}
		}
		check[cur.x][cur.y] = cnt;
	}

}

int main()
{
	cin >> mapSize;
	front = rear = -1;
	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++)
		{
			cin >> forest[i][j];
			check[i][j] = 1;
			push({ i,j,forest[i][j] });
		}
	}
	quickSort(0, rear);
	solve();

	for (int i = 0; i < mapSize; i++)
	{
		for (int j = 0; j < mapSize; j++)
		{
			if (check[i][j] > maxResult) maxResult = check[i][j];
		}
	}

	cout << maxResult << '\n';
	return 0;
}