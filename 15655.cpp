#include <cstdio>
#include <algorithm>

int N, cnt, arr[10], input[10];
bool check[10];

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

	for (register int i = idx+1; i <= N; i++)
	{
		if (!check[i])
		{
			check[i] = true;
			arr[cur] = input[i];
			solve(i, cur + 1);
			check[i] = false;
		}
	}
}

int main()
{
	scanf("%d %d", &N, &cnt);
	for (register int i = 1; i <= N; i++) scanf("%d", input + i);
	std::sort(input + 1, input + N + 1);
	solve(0, 0);
	return 0;
}