#include <stdio.h>
long long num;

int main()
{
	scanf("%lld", &num);

	int n = 1, res = 0;
	long long sum = 0;

	while (1)
	{
		sum += n;
		res++;

		if (sum > num)
		{
			res--;
			break;
		}
		n++;
	}

	printf("%d\n", res);
	return 0;
}