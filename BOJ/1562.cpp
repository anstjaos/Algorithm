#include <cstdio>
#include <algorithm>
#define DIV 1000000000
int N;
long long res;
long long dp[110][11][1 << 12];

long long tsp(int current, int last, int visited)
{
	if (last < 0 || last > 9) return 0;

	if (current == 1) {
		if ((visited | (1 << last)) == ((1 << 10) - 1)) return 1;
		return 0;
	}

	long long &ret = dp[current][last][visited];
	if (ret != -1) return ret;
	visited |= (1 << last);
	return ret = (tsp(current - 1, last - 1, visited) + tsp(current - 1, last + 1, visited) )% DIV;
}

int main()
{
	scanf("%lld", &N);
	
	int visit = (1 << 11);
	memset(dp, -1, sizeof(dp));
	for (register int i = 1; i <= 9; i++) {
		res += tsp(N, i,0) % DIV;
	}

	printf("%lld\n", res %DIV);
	return 0;
}