#include <iostream>
using namespace std;

int N;
int rope[100001];
int maxNum = -1;
void solve(int cnt)
{
	if (cnt == N+1) return;
	int sum = rope[cnt - 1];
	sum = sum * cnt;
	if (sum > maxNum) maxNum = sum;

	solve(cnt + 1);
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = rope[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (rope[leftIndex] > pivot) leftIndex++;
		while (rope[rightIndex] < pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(rope[leftIndex], rope[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> rope[i];
	}
	quickSort(0, N-1);
	solve(1);
	cout << maxNum << endl;
	return 0;
}