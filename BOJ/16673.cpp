#include <stdio.h>

int C, K, P;
long long result;

int main()
{
	scanf("%d %d %d", &C, &K, &P);
	for (register int i = 1; i <= C; i++) {
		result += (K*i + P * i*i);
	}

	printf("%lld\n", result);
	return 0;
}