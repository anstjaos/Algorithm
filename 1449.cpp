#include <iostream>
using namespace std;

bool tape[3000];
int hole[1001];
int N, L, temp, cnt;

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = hole[(left + right) / 2];
	while (leftIndex <= rightIndex)
	{
		while (hole[leftIndex] < pivot) leftIndex++;
		while (hole[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(hole[leftIndex], hole[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

int main()
{
	cin >> N >> L;

	for (int i = 0; i < N; i++)
	{
		cin >> temp;
		hole[i] = temp;
	}

	quickSort(0, N - 1);
	for (int i = 0; i < N; i++)
	{
		bool flag = true;
		int taping = hole[i] * 2 - 1;
		for (taping; taping <= hole[i] * 2 + 1; taping++)
		{
			if (tape[taping] == false)
			{
				flag = false;
				break;
			}
		}

		if (flag == true) continue;

		for (int i = 0; i <= 2 * L; i++)
		{
			tape[taping + i] = true;
		}
		cnt++;
	}

	cout << cnt << '\n';
	return 0;
}