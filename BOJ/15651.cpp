#include <cstdio>

int N, cnt, arr[10];

void solve(int cur)
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

	for (register int i = 1; i <= N; i++)
	{
		arr[cur] = i;
		solve(cur + 1);
	}
}

int main()
{
	scanf("%d %d", &N, &cnt);
	solve(0);
	return 0;
}