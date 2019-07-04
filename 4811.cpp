#include <stdio.h>
using namespace std;

long long dp[31][31];
int num;

long long solve(int w, int h)
{
	if ((w == 1 && h == 0) || w == 0) return 1;

	if (dp[w][h] != -1) return dp[w][h];

	long long result = 0;
	result += solve(w - 1, h + 1);

	if (h > 0) result += solve(w, h - 1);
	dp[w][h] = result;
	return result;
}

int main()
{
	for (int i = 0; i < 31; i++)
	{
		for (int j = 0; j < 31; j++) dp[i][j] = -1;
	}
	while (1)
	{
		scanf("%d", &num);
		if (num == 0) break;

		printf("%lld\n" ,solve(num - 1, 1));
	}
	return 0;
}