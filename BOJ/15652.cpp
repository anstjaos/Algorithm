#include <cstdio>

int N, cnt, arr[10];

void solve(int idx, int cur)
{
	if (cur == cnt)
	{
		for (register int i = 0; i < cnt; i++)
		{
			printf("%d ", arr[i]);
		}
		printf("\n");
		return;
	}

	for (register int i = idx; i <= N; i++)
	{
		arr[cur] = i;
		solve(i, cur + 1);
	}
}

int main()
{
	scanf("%d %d", &N, &cnt);
	solve(1, 0);
	return 0;
}