#include <cstdio>

int N, Q, arr[100005], pSum[100005][4], s, e;

int main()
{
	scanf("%d %d", &N, &Q);
	for (register int i = 1; i <= N; i++)
	{
		scanf("%d", arr + i);
		pSum[i][1] = pSum[i - 1][1];
		pSum[i][2] = pSum[i - 1][2];
		pSum[i][3] = pSum[i - 1][3];
		pSum[i][arr[i]]++;
	}

	for (register int i = 1; i <= Q; i++) {
		scanf("%d %d", &s, &e);
		printf("%d %d %d\n", pSum[e][1] - pSum[s - 1][1], pSum[e][2] - pSum[s - 1][2], pSum[e][3] - pSum[s - 1][3]);
	}

	return 0;
}