#include <stdio.h>

long long A, B, C;

int solve()
{
	long long res = 1;
	while (B > 0)
	{
		if (B & 1) {
			res *= A;
			res = res % C;
		}
		A = A * A % C;
		B >>= 1;
	}
	return res;
}

int main()
{
	scanf("%lld %lld %lld", &A, &B, &C);
	printf("%d\n", solve());
	return 0;
}