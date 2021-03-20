#include <stdio.h>
using namespace std;

#define MAX_INT 2123456789

int N, arr[16][16];
int dp[16][1 << 17];

int min(int a, int b) { return (a < b ? a : b); }

int solve(int cur, int visit)
{
	if (visit == (1 << N) - 1) {
		if (arr[cur][0] == 0) return MAX_INT;
		return arr[cur][0];
	}

	int &ret = dp[cur][visit];
	if (ret != 0) return ret;

	int res = MAX_INT;
	for (register int i = 1; i < N; i++) {
		if ((visit & (1 << i)) == 0 && arr[cur][i] != 0) {
			res = min(res, solve(i, (visit | (1 << i))) + arr[cur][i]);
		}
	}

	return ret = res;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%d", &arr[i][j]);
	}

	printf("%d\n", solve(0, 1));
	return 0;
}