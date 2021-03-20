#include <cstdio>

int N;

int main()
{
	scanf("%d", &N);

	for (register int i = 0; i < N; i++)
	{
		for (register int j = 1; j <= N; j++) {
			if (((j >> 1) << 1) == j) printf(" ");
			else printf("*");
		}
		printf("\n");
		if (N != 1)
		{
			for (register int j = 1; j <= N; j++) {
				if (((j >> 1) << 1) == j) printf("*");
				else printf(" ");
				
			}
			printf("\n");
		}
	}
	return 0;
}