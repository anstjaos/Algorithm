#include <cstdio>
#include <algorithm>

int N, colMax[3], tempMax[3], colMin[3], tempMin[3];
int max(int a, int b) { return (a > b ? a : b); }
int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++)
	{
		for (register int j = 0; j < 3; j++)
		{
			scanf("%d", tempMax + j);
			tempMin[j] = tempMax[j];
			tempMax[j] += max(colMax[1], (j == 1) ? max(colMax[0], colMax[2]) : colMax[j]);
			tempMin[j] += min(colMin[1], (j == 1) ? min(colMin[0], colMin[2]) : colMin[j]);
		}
		for (register int j = 0; j < 3; j++)
		{
			colMax[j] = tempMax[j];
			colMin[j] = tempMin[j];
		}
	}

	std::sort(colMax, colMax + 3);
	std::sort(colMin, colMin + 3);

	printf("%d %d\n", colMax[2], colMin[0]);
	return 0;
}