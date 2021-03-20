#include <iostream>
using namespace std;

int box[1001], dp[1001];
int boxCnt;
int max(int a, int b) { return a > b ? a : b; }
void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = box[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (box[leftIndex] < pivot) leftIndex++;
		while (box[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(box[leftIndex], box[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	cin >> boxCnt;
	for (int i = 0; i < boxCnt; i++)
	{
		cin >> box[i];
	}

	quickSort(0, boxCnt - 1);

	int result = 0;

	for (int i = 0; i < boxCnt; i++)
	{
		for (int j = 0; j < i; j++)
		{
			if (box[i] > box[j] && dp[j] + 1> dp[i]) dp[i] = dp[j] + 1;
		}
	}

	for (int i = 0; i < boxCnt; i++)
	{
		result = max(result, dp[i]);
	}

	cout << result << "\n";
	return 0;
}