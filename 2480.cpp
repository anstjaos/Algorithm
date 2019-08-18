#include <stdio.h>

int a, b, c, res;

int max(int n, int n1) { return (n > n1 ? n : n1); }
int main()
{
	scanf("%d %d %d", &a, &b, &c);

	if (a == b && a == c && b == c) {
		res = 10000 + a * 1000;
	}
	else if (a == b && a != c) res = 1000 + a * 100;
	else if (a == c && a != b) res = 1000 + a * 100;
	else if (b == c && a != b) res = 1000 + b * 100;
	else {
		res = max(a, max(b, c)) * 100;
	}

	printf("%d\n", res);
	return 0;
}