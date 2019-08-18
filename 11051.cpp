#include <iostream>
using namespace std;

#define DIVIDE 10007
typedef long long ll;
int N, K;
ll factorial[1002];

int main()
{
	scanf("%d %d", &N, &K);
	factorial[0] = 1;
	for (register int i = 1; i <= N; i++) factorial[i] = (factorial[i - 1] * i) % DIVIDE;

	ll result = factorial[N] % DIVIDE;
	ll temp = factorial[N - K] * factorial[K] % DIVIDE;

	ll divisor = 1;
	int p = DIVIDE - 2;
	while (p > 0)
	{
		if (p & 1) divisor = (divisor * temp) % DIVIDE;

		temp = (temp * temp) % DIVIDE;
		p = p >> 1;
	}

	printf("%lld\n", (result * divisor) % DIVIDE);
	return 0;
}