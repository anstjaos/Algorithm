#include <cstdio>
#define INF 2123456789

int N, arr[17][17], dp[17][1 << 17], res, P;
char input[17];

int min(int a, int b) { return (a < b ? a : b); }

int tsp(int current, int visited, int cnt)
{
	if (cnt >= P) {
		return 0;
	}
	int &ret = dp[current][visited];
	if (ret != -1) return ret;

	ret = INF;
	for (register int i = 0; i < N; i++)
	{
		if ((visited & (1<<i)) == 0) {
			int nextState = visited | (1 << i);
			
			for (register int j = 0; j < N; j++)
				if ((nextState & (1 << j))) //해당 발전소를 킨 다음 단계로 이동
					ret = min(ret, arr[current][i] + tsp(j, nextState, cnt+1));
		}
	}
	return ret;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) scanf("%d", &arr[i][j]);
	}
	int visit = (1 << (N+1));
	int cnt = 0;
	scanf("%s", input);
	for (register int i = 0; i < N; i++) {
		if (input[i] == 'Y')
		{
			visit |= (1 << i);
			cnt++;
		}
	}
	scanf("%d", &P);
	
	if (P == 0) printf("0\n");
	else {
		for (register int i = 0; i < 17; i++) {
			for (register int j = 0; j < (1 << 17); j++) dp[i][j] = -1;
		}

		res = INF;
		for (register int i = 0; i < N; i++) {
			if (input[i] == 'Y') {
				res = min(res, tsp(i, visit, cnt));
			}
		}
		res == INF ? printf("-1\n") : printf("%d\n", res);
	}
	
	return 0;
}