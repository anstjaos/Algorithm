#include <stdio.h>

int N;
long long d[1001];

int main() {
	scanf("%d", &N);
	for (int i = 0; i <= 6; i++) {
		d[i] = i;
	}
	for (int i = 7; i <= N; i++) {
		for (int j = 3; j <= i - 1; j++) {
			long long cur = d[i - j] * (j - 1);
			if (cur > d[i]) {
				d[i] = cur;
			}
		}
	}
	printf("%lld\n", d[N]);
	return 0;
}