#include <stdio.h>

int N, M, res;
char arr[51][51];

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	res = 1;
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++) scanf("%s", arr + i);
	
	for (register int i = 0; i < N - 1; i++) {
		for (register int j = 0; j < M - 1; j++) {
			for (register int s = 1; i + s < N && j + s < M; s++) {
				if (arr[i][j] == arr[i + s][j] && arr[i][j] == arr[i][j + s] && arr[i][j] == arr[i + s][j + s]) {
					res = max(res, (s+1)*(s+1));
				}
			}
		}
	}

	printf("%d\n", res);
	return 0;
}