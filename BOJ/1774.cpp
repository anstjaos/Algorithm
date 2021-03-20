#include <stdio.h>
#include <math.h>

#define MAX_SIZE 1004

typedef struct {
	double x;
	double y;
}God;

typedef struct {
	int from;
	int to;
	double dist;
}Dist;

int N, M, parent[MAX_SIZE], distCnt;
God godArr[MAX_SIZE];
Dist distArr[MAX_SIZE * MAX_SIZE];

bool isAllConnect()
{
	for (register int i = 1; i < N; i++) {
		if (parent[i] != parent[i - 1]) return false;
	}

	return true;
}
int findParent(int u)
{
	if (u == parent[u]) return u;
	return parent[u] = findParent(parent[u]);
}

bool unionSet(int u, int v)
{
	int uParent = findParent(u);
	int vParent = findParent(v);

	if (uParent == vParent) return false;

	if (uParent < vParent) parent[vParent] = uParent;
	else parent[uParent] = vParent;

	return true;
}

double getDist(God &a, God &b)
{
	return sqrt(pow((a.x - b.x), 2) + pow((a.y - b.y), 2));
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	double pivot = distArr[(left + right) / 2].dist;

	while (leftIndex <= rightIndex)
	{
		while (distArr[leftIndex].dist < pivot) {
			if (leftIndex == right) break;
			leftIndex++;
		}
		while (distArr[rightIndex].dist > pivot) {
			if (rightIndex == left) break;
			rightIndex--;
		}

		if (leftIndex <= rightIndex)
		{
			Dist temp = distArr[leftIndex];
			distArr[leftIndex] = distArr[rightIndex];
			distArr[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

int main()
{
	scanf("%d %d", &N, &M);
	double x, y;

	for (register int i = 0; i < N; i++) {
		parent[i] = i;
		scanf("%lf %lf", &x, &y);
		godArr[i] = { x,y };
	}

	int a, b;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &a, &b);
		unionSet(a-1, b-1);
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = i + 1; j < N; j++) {
			distArr[distCnt++] = { i,j, getDist(godArr[i], godArr[j]) };
		}
	}

	quickSort(0, distCnt - 1);
	double sum = 0.0;
	for (register int i = 0; i < distCnt; i++) {
		if (isAllConnect()) break;
		if (!unionSet(distArr[i].from, distArr[i].to)) continue;

		sum += distArr[i].dist;
	}

	printf("%.2lf\n", sum);
	return 0;
}