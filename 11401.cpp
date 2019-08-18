#include <iostream>
using namespace std;

#define MOD 1000000007
int N, K;
long long factorial[4000001];

int main()
{
	scanf("%d %d", &N, &K);
	factorial[0] = factorial[1] = 1;

	for (register int i = 2; i <= N; i++) factorial[i] = (factorial[i - 1] * i) % MOD;
	long long temp = (factorial[K] * factorial[N - K]) % MOD;
	
	int p = MOD -2;
	long long divisor = 1;
	while (p > 0)
	{
		if (p & 1)
		{
			divisor *= temp;
			divisor %= MOD;
		}
		temp *= temp;
		temp %= MOD;
		p = p / 2;
	}

	long long result = ((factorial[N] % MOD) * (divisor % MOD)) % MOD;
	printf("%lld\n", result);
	return 0;
}