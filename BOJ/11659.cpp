#include <cstdio>
#define MAX_SIZE 100005

int arr[MAX_SIZE], pSum[MAX_SIZE], N, M, s ,e;

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 1; i <= N; i++) scanf("%d", arr + i);
	for (register int i = 1; i <= N; i++) {
		pSum[i] = pSum[i - 1] + arr[i];
	}

	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &s, &e);
		printf("%d\n", pSum[e] - pSum[s-1]);
	}
	return 0;
}