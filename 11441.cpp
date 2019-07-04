#include <cstdio>

int N, M, arr[100005], pSum[100005], s, e;

int main()
{
	scanf("%d", &N);
	for (register int i = 1; i <= N; i++) {
		scanf("%d", arr + i);
		pSum[i] = pSum[i - 1] + arr[i];
	}

	scanf("%d", &M);
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &s, &e);
		printf("%d\n", pSum[e] - pSum[s - 1]);
	}
	return 0;
}