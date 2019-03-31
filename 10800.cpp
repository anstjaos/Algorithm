#include <iostream>
using namespace std;

typedef struct {
	int color, ballSize, index;
}ball;

ball ballArr[200001];
int ballCnt, color[200001], result[200001];
int total;

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = ballArr[(left + right) / 2].ballSize;

	while (leftIndex <= rightIndex)
	{
		while (ballArr[leftIndex].ballSize < pivot) leftIndex++;
		while (ballArr[rightIndex].ballSize > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(ballArr[leftIndex], ballArr[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (left < rightIndex) quickSort(left, rightIndex);
	if (leftIndex < right) quickSort(leftIndex, right);
}

int main()
{
	cin >> ballCnt;
	for (int i = 0; i < ballCnt; i++)
	{
		cin >> ballArr[i].color >> ballArr[i].ballSize;
		ballArr[i].index = i;
	}

	quickSort(0, ballCnt - 1);
	
	for (int i = 0, j =0; i < ballCnt; i++)
	{
		for (; ballArr[j].ballSize < ballArr[i].ballSize; j++)
		{
			color[ballArr[j].color] = color[ballArr[j].color] + ballArr[j].ballSize;
			total = total + ballArr[j].ballSize;
		}
		
		result[ballArr[i].index] = total - color[ballArr[i].color];
	}

	for (int i = 0; i < ballCnt; i++)
	{
		cout << result[i] << '\n';
	}
	return 0;
}