#include <stdio.h>

int A[101][101], B[101][101];
int N, M;

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < M; j++) scanf("%d", &A[i][j]);
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < M; j++) scanf("%d", &B[i][j]);
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < M; j++) {
			A[i][j] += B[i][j];
		}
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < M; j++) printf("%d ", A[i][j]);
		printf("\n");
	}

	return 0;
}