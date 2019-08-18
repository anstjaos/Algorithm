#include <iostream>
#define MOD 1000000007

int M, N, S, power;
long long temp, sum, divisor;

int main()
{
	scanf("%d", &M);
	for (register int i = 0; i < M; i++) {
		scanf("%d %d", &S, &N);
		temp = N;
		power = MOD - 2;
		divisor = S;

		while (power > 0)
		{
			if (power & 1) {
				temp =( temp * divisor) % MOD;
			}
			power = power >> 1;
			divisor = (divisor*divisor) %MOD;
		}
		sum = (sum + temp) % MOD;
	}

	printf("%lld\n", sum);
	return 0;
}