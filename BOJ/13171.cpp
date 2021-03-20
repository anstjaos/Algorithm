#include <cstdio>

const int p = 1000000007;

int main() {
	int i, r;
	long long a, b;
	scanf("%lld%lld", &a, &b);

	a %= p;
	b %= p - 1;
	for (r = 1; b; b >>= 1) {
		if (b & 1) r = r * a % p;
		a = a * a % p;
	}
	printf("%d", r);
}