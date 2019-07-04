#include <cstdio>

int N;

int main()
{
	scanf("%d", &N);
	if (N == 1) {
		printf("*\n");
	}
	else {
		for (register int i = 1; i <= N; i++)
		{
			for (register int j = 1; j <= 2 * N; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					printf("*");
				}
				else if (i % 2 == 0 && j % 2 == 1) {
					printf(" ");
				}
				else if (i % 2 == 1 && j % 2 == 0) {
					printf(" ");
				}
				else if (i % 2 == 1 && j % 2 == 1) {
					printf("*");
				}
			}
			printf("\n");
		}
	}
	return 0;
}