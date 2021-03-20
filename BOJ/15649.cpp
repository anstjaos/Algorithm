#include <stdio.h>

int M, N, arr[10];
bool check[10];

void solve(int depth)
{
	if (depth == N) {
		for (register int i = 0; i < N; i++) {
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}

	for (register int i = 1; i <= M; i++) {
		if (!check[i]) {
			check[i] = true;
			arr[depth] = i;
			solve(depth + 1);
			check[i] = false;
		}
	}
}

int main()
{
	scanf("%d %d", &M, &N);
	solve(0);
	return 0;
}