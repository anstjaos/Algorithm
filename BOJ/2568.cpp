#include <iostream>
using namespace std;

typedef struct {
	int left, right;
}line;

typedef struct {
	int value, before;
}dp;

line lineArr[100002];
dp dpArr[100002];
int lineCnt;

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = lineArr[(left + right) / 2].left;

	while (leftIndex <= rightIndex)
	{
		while (lineArr[leftIndex].left < pivot) leftIndex++;
		while (lineArr[rightIndex].left > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(lineArr[leftIndex], lineArr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}
	
	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

void solve()
{
	for (int i = 0; i < lineCnt; i++)
	{

	}
}

int main()
{
	cin >> lineCnt;
	for (int i = 0; i < lineCnt; i++)
	{
		cin >> lineArr[i].left >> lineArr[i].right;
	}

	quickSort(0, lineCnt - 1);
	solve();
}