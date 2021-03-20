#include <iostream>
using namespace std;

#define QUEUE_SIZE 100001

typedef struct {
	int x;
	int y;
	int age;
}tree;

tree alive[QUEUE_SIZE];
tree dead[QUEUE_SIZE];
int aFront, aRear, dFront, dRear;
int N, M, K, arr[11][11], cur[11][11];
int dirX[8] = { -1,-1,0,1,1,1,0,-1 };
int dirY[8] = { 0,1,1,1,0,-1,-1,-1 };

void alivePush(tree item)
{
	aRear = (aRear + 1) % QUEUE_SIZE;
	alive[aRear] = item;
}

void pushFront(tree item)
{
	alive[aFront] = item;
	aFront = (aFront - 1 + QUEUE_SIZE) % QUEUE_SIZE;
}

tree alivePop()
{
	aFront = (aFront + 1) % QUEUE_SIZE;
	return alive[aFront];
}

void deadPush(tree item)
{
	dRear = (dRear + 1) % QUEUE_SIZE;
	dead[dRear] = item;
}

tree deadPop()
{
	dFront = (dFront + 1) % QUEUE_SIZE;
	return dead[dFront];
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = alive[(left + right) / 2].age;

	while (leftIndex <= rightIndex)
	{
		while (alive[leftIndex].age < pivot) leftIndex++;
		while (alive[rightIndex].age > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(alive[leftIndex], alive[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

void spring()
{
	int size = (aRear - aFront + QUEUE_SIZE) % QUEUE_SIZE;
	
	dRear = dFront = -1;

	for (register int i = 0; i < size; i++) {
		tree curT = alivePop();

		if (cur[curT.x][curT.y] - curT.age >= 0)
		{
			cur[curT.x][curT.y] -= curT.age;
			curT.age++;
			alivePush(curT);
		}
		else {
			deadPush(curT);
		}
	}
}

void summer()
{
	while (dFront != dRear)
	{
		tree curT = deadPop();
		cur[curT.x][curT.y] += curT.age / 2;
	}
}

void fall()
{
	int size = (aRear - aFront + QUEUE_SIZE) % QUEUE_SIZE;
	int first = aFront;
	for (register int i = 1; i <= size; i++) {
		tree curT = alive[(first + i) % QUEUE_SIZE];
		if (curT.age % 5 == 0)
		{
			for (register int j = 0; j < 8; j++)
			{
				int nextX = curT.x + dirX[j];
				int nextY = curT.y + dirY[j];

				if (nextX <= 0 || nextY <= 0 || nextX > N || nextY > N) continue;

				pushFront({ nextX,nextY, 1 });
			}
		}
	}
}

void winter()
{
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++)
		{
			cur[i][j] += arr[i][j];
		}
	}
}

int main()
{
	aFront = aRear = -1;
	scanf("%d %d %d", &N, &M, &K);
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++)
		{
			scanf("%d", &arr[i][j]);
			cur[i][j] = 5;
		}
	}

	for (int i = 0; i < M; i++) {
		tree temp;
		scanf("%d %d %d", &temp.x, &temp.y, &temp.age);
		alivePush(temp);
	}
	quickSort(aFront + 1, aRear);

	while (K--)
	{
		spring();
		summer();
		fall();
		winter();
	}

	printf("%d\n", (aRear - aFront + QUEUE_SIZE) % QUEUE_SIZE);
	return 0;
}