#include <stdio.h>
#include <math.h>

int M, N, res, minVal;

int main()
{
	scanf("%d %d", &M, &N);

	for (register int i = M; i <= N; i++) {
		int sq = (int)sqrt(i);
		if (sq * sq == i)
		{
			res += i;
			if (minVal == 0) minVal = i;
		}
	}

	res > 0 ? printf("%d\n%d\n", res, minVal) : printf("-1\n");
	return 0;
}