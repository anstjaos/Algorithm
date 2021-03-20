#include <iostream>
using namespace std;

typedef struct {
	int from, to, weight;
}edge;

long long result;
int vertexCnt, edgeCnt;
int parents[10001];
edge edgeArr[100001];

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = edgeArr[(left + right) / 2].weight;

	while (leftIndex <= rightIndex)
	{
		while (edgeArr[leftIndex].weight < pivot) leftIndex++;
		while (edgeArr[rightIndex].weight > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(edgeArr[leftIndex], edgeArr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

void makeSet()
{
	for (int i = 1; i <= vertexCnt; i++) parents[i] = i;
}

int findSet(int x)
{
	if (parents[x] == x) return x;
	else return findSet(parents[x]);
}

void unionSet(int x, int y)
{
	parents[findSet(y)] = findSet(x);
}

void solve()
{
	int cnt = 0;
	for (int i = 0; i < edgeCnt; i++)
	{
		if(findSet(edgeArr[i].from) != findSet(edgeArr[i].to))
		{
			result = result + edgeArr[i].weight;

			unionSet(edgeArr[i].from, edgeArr[i].to);
			cnt++;
		}

		if (cnt == vertexCnt - 1) break;
	}
}

int main()
{
	cin >> vertexCnt >> edgeCnt;
	makeSet();
	for (int i = 0; i < edgeCnt; i++)
	{
		cin >> edgeArr[i].from >> edgeArr[i].to >> edgeArr[i].weight;
	}

	quickSort(0, edgeCnt - 1);
	solve();
	cout << result << '\n';
	return 0;
}