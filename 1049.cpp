#include <iostream>
#include <algorithm>
using namespace std;

int N, M, lineSet[51], line[51], result = 2123456789;

int min(int a, int b) { return (a < b ? a : b); }
int main()
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < M; i++)
	{
		scanf("%d %d", lineSet + i, line + i);
	}
	sort(lineSet, lineSet + M);
	sort(line, line + M);

	int temp = N / 6;
	result = min(result, temp * lineSet[0] + (N % 6 * line[0]));
	result = min(result, N * line[0]);
	result = min(result, (temp + 1) * lineSet[0]);

	printf("%d\n", result);

	return 0;
}