#include <stdio.h>

int n;

int solve(int num)
{
	if (num == 1) {
		printf("1! = 1\n");
		return 1;
	}

	int ret = num;
	printf("%d! = %d * %d!\n", num, num, num - 1);
	ret *= solve(num - 1);
	return ret;
}

int main()
{
	scanf("%d", &n);
	printf("%d\n",solve(n));
	return 0;
}