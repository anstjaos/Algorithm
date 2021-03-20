#include <iostream>
#include <algorithm>
using namespace std;

typedef struct {
	int start;
	int end;
}talk;

talk arr[1000001];

int maxNum = 0;
int n;

int cmp(const talk &a, const talk &b)
{
	if (a.end == b.end) return a.start < b.start;
	else return a.end < b.end;
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = arr[(left + right) / 2].end;

	while (leftIndex <= rightIndex)
	{
		while (arr[leftIndex].end < pivot) leftIndex++;
		while (arr[rightIndex].end > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(arr[leftIndex], arr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i].start >> arr[i].end;
	}

	sort(arr, arr + n, cmp);
	int last = -1;
	for (int i = 0; i < n; i++)
	{
		if (arr[i].start >= last)
		{
			last = arr[i].end;
			maxNum++;
		}
	}

	
	cout << maxNum << endl;
	return 0;
}