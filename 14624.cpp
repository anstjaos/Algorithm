#include <stdio.h>

int n;
int main()
{
	scanf("%d", &n);

	if (((n >> 1) << 1) == n) {
		printf("I LOVE CBNU\n");
	}
	else {
		for (register int i = 0; i < n; i++) printf("*");
		printf("\n");
		for (register int i = ((n - 1) >> 1); i >= 0; i--) {
			for(register int j =0; j < i; j++) printf(" ");
			if (i != ((n - 1) >> 1)) {
				printf("*");
				for (register int j = 0; j < (((n - 1) >> 1)-i) * 2 - 1; j++) printf(" ");
			}
			printf("*\n");

		}
	}
	return 0;
}