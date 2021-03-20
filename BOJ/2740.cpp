#include <iostream>
using namespace std;

int N, M, K, matrixA[101][101], matrixB[102][102], matrixR[101][101];

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < M; j++) {
			scanf("%d", &matrixA[i][j]);
		}
	}

	scanf("%d %d", &M, &K);
	for (register int i = 0; i < M; i++) {
		for (register int j = 0; j < K; j++) {
			scanf("%d", &matrixB[i][j]);
		}
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < K; j++) {
			for (register int k = 0; k < M; k++) {
				matrixR[i][j] += matrixA[i][k] * matrixB[k][j];
			}
		}
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < K; j++) {
			printf("%d ", matrixR[i][j]);
		}
		printf("\n");
	}

	return 0;
}