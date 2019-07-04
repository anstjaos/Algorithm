#include <cstdio>

int N, M, arr[10];
bool input[10001];

void solve(int idx, int cnt)
{
	if (cnt == M)
	{
		for (register int i = 0; i < M; i++) printf("%d ", arr[i]);
		printf("\n");
		return;
	}


	for (register int i = idx; i < 10001; i++)
	{
		if (input[i])
		{
			arr[cnt] = i;
			solve(i, cnt + 1);
		}
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++)
	{
		int temp;
		scanf("%d", &temp);
		input[temp] = true;
	}

	solve(0, 0);
	return 0;
}