#include <iostream>
#include <algorithm>
using namespace std;

typedef struct {
	int index;
	int num;
}Segment;
int N, input, height, arr[400005];
Segment segArr[200005];

int max(int a, int b) { return (a > b ? a : b); }

bool comp(Segment& a, Segment& b)
{
	if (a.num == b.num)
	{
		return a.index > b.index;
	}
	
	return a.num < b.num;
}

int main()
{
	scanf("%d", &N);
	while ((1 << height) < N) height++;

	for (register int i = 0; i < N; i++) {
		scanf("%d", &input);
		segArr[i].index = i;
		segArr[i].num = input;
	}
	sort(segArr, segArr + N, comp);

	for (register int i = 0; i < N; i++)
	{
		int index = segArr[i].index;
		int maxNum = 0;
		for (register int j = (1 << height); j < (1 << height) + index; j++)
		{
			maxNum = max(maxNum, arr[j]);
		}
		arr[(1 << height) + index] = maxNum + 1;
	}

	for (register int i = height - 1; i >= 0; i--)
	{
		for (register int j = (1 << i); j < 1 << (i + 1); j++)
		{
			arr[j] = max(arr[j * 2],arr[j * 2 + 1]);
		}
	}

	printf("%d\n", arr[1]);
	return 0;
}