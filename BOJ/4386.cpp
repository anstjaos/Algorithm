#include <stdio.h>
#include <math.h>

typedef struct {
	double x;
	double y;
}Star;

typedef struct {
	int from;
	int to;
	double dist;
}Dist;

int n, parent[101], cnt;
Star starArr[101];
Dist distArr[10001];

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	double pivot = distArr[(left + right) /2].dist;

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

double getDist(Star &a, Star &b)
{
	return sqrt(pow((a.x - b.x), 2) + pow((a.y - b.y),2));
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

int main()
{
	scanf("%d", &n);
	for (register int i = 0; i < n; i++) parent[i] = i;
	for (register int i = 0; i < n; i++) {
		scanf("%lf %lf", &starArr[i].x, &starArr[i].y);
	}

	for (register int i = 0; i < n; i++) {
		for (register int j = i + 1; j < n; j++) {
			distArr[cnt++] = { i,j, getDist(starArr[i], starArr[j]) };
		}
	}

	quickSort(0, cnt - 1);
	int selectCnt = 0;
	double sum = 0.0;
	for (register int i = 0; i < n; i++)
	{
		if (!unionSet(distArr[i].from, distArr[i].to)) continue;

		sum += distArr[i].dist;
		selectCnt++;
		if (selectCnt == n - 1) break;
	}

	printf("%.2lf\n", sum);
	return 0;
}