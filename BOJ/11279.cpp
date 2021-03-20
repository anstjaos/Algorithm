#include <iostream>
using namespace std;

int arr[300001], curCnt, N;
int temp;

void push(int num)
{
	arr[++curCnt] = num;
	int cur = curCnt;
	int parent = curCnt / 2;

	while (cur != 1 && arr[parent] < arr[cur])
	{
		swap(arr[parent], arr[cur]);
		cur /= 2;
		parent /= 2;
	}
}

int getMax()
{
	int result = arr[1];
	arr[1] = arr[curCnt];
	arr[curCnt] = 0;
	if(curCnt != 0 ) curCnt--;

	int cur = 1;
	int next;

	while (1)
	{
		if (arr[cur * 2] > arr[cur * 2 + 1]) next = cur * 2;
		else next = cur * 2 + 1;

		if (arr[cur] >= arr[next]) break;

		swap(arr[cur], arr[next]);
		cur = next;
	}

	return result;
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &temp);
		if (temp == 0)
		{
			printf("%d\n", getMax());
		}
		else push(temp);
	}
}