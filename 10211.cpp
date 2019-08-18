#include <cstdio>

int tc, N, arr[1005], pSum[1005], res;

int max(int a, int b) { return (a > b ? a : b); }

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d", &N);
		res = -10001;
		for (register int i = 1; i <= N; i++) {
			scanf("%d", arr + i);
			res = max(res, arr[i]);
			pSum[i] = pSum[i - 1] + arr[i];
			res = max(res, pSum[i]);
		}

		for (register int i = 1; i <= N; i++) {
			for (register int j = i - 1; j >= 0; j--) {
				if (arr[j] > 0) continue;

				res = max(res, pSum[i] - pSum[j]);
			}
		}

		printf("%d\n", res);
	}
	return 0;
}