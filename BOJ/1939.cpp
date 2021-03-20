#include <iostream>
#include <vector>
using namespace std;

typedef struct {
	int to;
	long long weight;
}bridge;

vector<bridge> arr[10001];
long long weightArr[100001];
bool visit[10001];
int start, desti, from, to, weight;
int N, M;

long long max(long long a, long long b) { return (a > b ? a : b); }

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	long long pivot = weightArr[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (weightArr[leftIndex] < pivot) leftIndex++;
		while (weightArr[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(weightArr[leftIndex], weightArr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

bool bridgeTest(long long weight, int from)
{
	bool result = false;
	if (from == desti) return true;

	int size = arr[from].size();
	for (int i = 0; i < size; i++)
	{
		if (visit[arr[from][i].to] == false && arr[from][i].weight >= weight)
		{
			visit[arr[from][i].to] =true;
			result = bridgeTest(weight, arr[from][i].to);
			if (result == true) return true;

			visit[arr[from][i].to] = false;
		}
	}

	return result;
}

int main()
{
	cin >> N >> M;

	for (int i = 0; i < M; i++)
	{
		cin >> from >> to >> weight;

		arr[from].push_back({ to,weight });
		arr[to].push_back({ from,weight });

		weightArr[i] = weight;
	}
	cin >> start >> desti;

	quickSort(0, M - 1);

	int left = 0;
	int right = M - 1;

	long long result = 0;
	while (left <= right)
	{
		visit[start] = true;
		int mid = (left + right) / 2;

		if (bridgeTest(weightArr[mid], start))
		{
			result = weightArr[mid];
			left = mid + 1;
		}
		else right = mid - 1;

		for (int i = 1; i <= N; i++) visit[i] = false;
	}

	cout << result << endl;
	return 0;
}