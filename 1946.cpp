#include <iostream>
using namespace std;

typedef struct
{
	int first, second;
}test;

test testArr[100001];
int testCase, testCnt, first, second;
int lastSecond;

void sortByFirst(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = testArr[(left + right) / 2].first;

	while (leftIndex <= rightIndex)
	{
		while (testArr[leftIndex].first < pivot) leftIndex++;
		while (testArr[rightIndex].first > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(testArr[leftIndex], testArr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) sortByFirst(left, rightIndex);
	if (leftIndex < right) sortByFirst(leftIndex, right);
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		int result = 0;
		lastSecond = 2123456789;

		cin >> testCnt;
		for (int j = 0; j < testCnt; j++)
		{
			cin >> first >> second;
			test t;
			t.first = first;
			t.second = second;
			testArr[j] = t;
		}

		sortByFirst(0, testCnt - 1);
		for (int j = 0; j < testCnt; j++)
		{
			if (testArr[j].second < lastSecond)
			{
				lastSecond = testArr[j].second;
				result++;
			}
		}

		cout << result << endl;
	}

	return 0;
}