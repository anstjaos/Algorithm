#include <cstdio>

int N;

int main()
{
	scanf("%d", &N);
	for (register int i = 1; i <= N; i++) {
		for (register int j = 0; j < N - i; j++) printf(" ");
		printf("*");
		for (register int j = 0; j < 2 * (i - 1) - 1; j++) printf(" ");
		if (i != 1) printf("*");
		printf("\n");
	}
	return 0;
}