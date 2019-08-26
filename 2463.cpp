#include <stdio.h>
#define DIV 1000000000
#define MAX_SIZE 1000001

typedef struct {
	int from;
	int to;
	int cost;
}Edge;

Edge edgeArr[MAX_SIZE];
int N, M, parent[MAX_SIZE], rank[MAX_SIZE];

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = edgeArr[(left + right) / 2].cost;

	while (leftIndex <= rightIndex) {
		while (edgeArr[leftIndex].cost > pivot) {
			if (leftIndex == right) break;
			leftIndex++;
		}

		while (edgeArr[rightIndex].cost < pivot) {
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

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int findParent(int idx)
{
	if (parent[idx] == idx) return idx;
	return parent[idx] = findParent(parent[idx]);
}

void unionSet(int u, int v)
{
	if (u < v) {
		parent[v] = u;
		rank[u] += rank[v];
		rank[v] = 1;
	}
	else {
		parent[u] = v;
		rank[v] += rank[u];
		rank[u] = 1;
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i <= N; i++) {
		parent[i] = i;
		rank[i] = 1;
	}

	int a, b, c;
	long long total = 0;
	for (register int i = 0; i < M; i++) {
		scanf("%d %d %d", &a, &b, &c);
		edgeArr[i] = { a,b,c };
		total += c;
	}

	long long res = 0;
	quickSort(0, M - 1);

	for (register int i = 0; i < M; i++) {
		int uParent = findParent(edgeArr[i].from);
		int vParent = findParent(edgeArr[i].to);
		int cost = edgeArr[i].cost;

		if (uParent != vParent)
		{
			res += ((rank[uParent] * rank[vParent] % DIV) * total) % DIV;
			res %= DIV;
			unionSet(uParent, vParent);
		}
		total -= cost;
	}

	printf("%lld\n", res);
	return 0;
}