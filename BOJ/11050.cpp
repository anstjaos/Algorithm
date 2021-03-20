#include <iostream>
using namespace std;

int factorial[12], N, K;

int main()
{
	scanf("%d %d", &N, &K);
	factorial[0] = 1;
	for (int i = 1; i <= 10; i++)
	{
		factorial[i] = factorial[i - 1] * i;
	}

	long long result = factorial[N] / factorial[K] / factorial[N - K];
	printf("%lld\n", result);
	return 0;
}