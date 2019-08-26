#include <stdio.h>

long long a[6][6], res[6][6], N, B;

void cal(long long b[][6], long long c[][6])
{
	long long ret[6][6];
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {

			ret[i][j] = 0;
			for (register int k = 0; k < N; k++) {
				ret[i][j] += b[i][k] * c[k][j];
			}
			ret[i][j] %= 1000;
		}
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) b[i][j] = ret[i][j];
	}
}

int main()
{
	scanf("%lld %lld", &N, &B);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%lld", &a[i][j]);
		res[i][i] = 1;
	}

	while (B > 0)
	{
		if (B & 1) {
			cal(res, a);
		}
		cal(a, a);
		B >>= 1;
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) printf("%lld ", res[i][j]);
		printf("\n");
	}

	return 0;
}