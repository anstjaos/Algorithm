#include <stdio.h>

int N, arr[1001], dp1[1001], dp2[1001], res;

int max(int a, int b) { return (a > b ? a : b); }
int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d", arr + i);
	}

	for (register int i = 0; i < N; i++) {
		dp1[i] = 1;
		for (register int j = 0; j < i; j++) {
			if (arr[i] > arr[j] && dp1[i] < dp1[j] + 1) {
				dp1[i] = dp1[j] + 1;
			}
		}
	}

	for (register int i = N - 1; i >= 0; i--) {
		dp2[i] = 1;
		for (register int j = i + 1; j < N; j++) {
			if (arr[i] > arr[j] && dp2[i] < dp2[j] + 1) {
				dp2[i] = dp2[j] + 1;
			}
		}
	}

	for (register int i = 0; i < N; i++) {
		res = max(res, dp1[i] + dp2[i] - 1);
	}
	printf("%d\n", res);
	return 0;
}