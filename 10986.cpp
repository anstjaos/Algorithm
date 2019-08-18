#include <cstdio>

int N, M, arr[100005];
long long pSum[100005], res, sum[100005];

int main()
{
	scanf("%d %d", &N, &M);

	for (register int i = 1; i <= N; i++) {
		scanf("%d", arr + i);
		pSum[i] = (pSum[i - 1] + arr[i]) % M;
		if (pSum[i] == 0) res++;
		sum[pSum[i]]++;
	}

	for (register int i = 0; i < M; ++i) if (sum[i]) res += sum[i] * (sum[i] - 1) / 2;
	

	printf("%lld\n", res);
	return 0;
}