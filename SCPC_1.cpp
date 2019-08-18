#include <stdio.h>
#define MAX_SIZE 1000005

int answer, dp[MAX_SIZE];

int recursiveDP(int num)
{
	int &ret = dp[num];
	if (ret != -1) return ret;

	ret = 0;
	if (((num >> 1) << 1) == num) ret = recursiveDP(num / 2) + 1;
	else ret = recursiveDP(num + 1) + 1;

	return ret;
}

void init()
{
	for (register int i = 2; i < MAX_SIZE; i++) dp[i] = -1;
	dp[1] = 0;

	for (register int i = 2; i < MAX_SIZE; i++)
	{
		recursiveDP(i);
	}
}

int main()
{
	int testCase;
	scanf("%d", &testCase);

	init();
	for (register int t = 1; t <= testCase; t++)
	{
		int N1, N2;
		scanf("%d %d", &N1, &N2);
		answer = 0;
		for (register int i = N1; i <= N2; i++) answer += dp[i];
		printf("Case #%d\n%d\n", t, answer);
	}
	return 0;
}