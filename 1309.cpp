#include <iostream>
using namespace std;
#define DIV 9901

int dp[100001], sum[100001], N;

int main()
{
	scanf("%d", &N);
	dp[1] = 1; sum[1] = 1;
	dp[2] = 2; sum[2] = 3;

	for (register int i = 3; i <= N; i++)
	{
		dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % DIV;
		sum[i] = (dp[i] + sum[i - 1]) % DIV;
	}

	printf("%d\n", (sum[N] * 2 + 1) % DIV);
	return 0;
}