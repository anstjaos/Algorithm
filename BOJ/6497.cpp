#include <stdio.h>

typedef struct {
	int from;
	int to;
	int cost;
}Edge;

Edge edgeArr[200005];
int N, M, parent[200005];

void quickSort(const int left, const int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = edgeArr[(left + right) / 2].cost;

	while (leftIndex <= rightIndex)
	{
		while (edgeArr[leftIndex].cost < pivot) {
			if (leftIndex == right) break;
			leftIndex++;
		}
		while (edgeArr[rightIndex].cost > pivot) {
			if (rightIndex == left) break;
			rightIndex--;
		}

		if (leftIndex <= rightIndex)
		{
			Edge temp = edgeArr[leftIndex];
			edgeArr[leftIndex] = edgeArr[rightIndex];
			edgeArr[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

int findParent(int u)
{
	if (parent[u] == u) return u;
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
	while (1)
	{
		scanf("%d %d", &N, &M);
		if (N == 0 && M == 0) break;
		for (register int i = 1; i <= N; i++) parent[i] = i;

		int a, b, c, sum = 0;
		for (register int i = 0; i < M; i++) {
			scanf("%d %d %d", &a, &b, &c);
			edgeArr[i] = { a,b,c };
			sum += c;
		}

		quickSort(0, M - 1);
		int cnt = 0;
		for (register int i = 0; i < M; i++) {
			if (unionSet(edgeArr[i].from, edgeArr[i].to)) {
				cnt++;
				sum -= edgeArr[i].cost;
			}

			if (cnt == N - 1) break;
		}
		printf("%d\n", sum);
	}

	return 0;
}