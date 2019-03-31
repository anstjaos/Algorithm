#include <iostream>
using namespace std;

char num[100001];
int arrCnt;
int maxNum;

int strlen1(char *a)
{
	int index = 0;
	while (a[index] != '\0')
	{
		index++;
	}
	return index;
}
void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	char pivot = num[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (num[leftIndex] < pivot) leftIndex++;
		while (num[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(num[leftIndex], num[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

int main()
{
	cin >> num;
	maxNum = -1;
	int sum = 0;
	bool zeroflag = false;
	arrCnt = strlen1(num);
	for(int i =0; i < arrCnt; i++)
	{
		sum = sum + num[i] - '0';
		if (num[i] -'0' == 0) zeroflag = true;
	}

	if (zeroflag == false || sum % 3 != 0)
	{
		cout << "-1" << endl;
		return 0;
	}
	quickSort(0, arrCnt - 1);

	for (int i = arrCnt - 1; i >= 0; i--)
	{
		cout << num[i];
	}
	cout << endl;
}