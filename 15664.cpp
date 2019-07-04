#include <cstdio>
#include <algorithm>

int N, M, input[10], arr[10];
bool used[10];

void solve(int idx, int cnt)
{
	if (cnt == M)
	{
		for (register int i = 0; i < M; i++) printf("%d ", arr[i]);
		printf("\n");
		return;
	}

	bool check[10001] = { 0, };
	for (register int i = idx; i < N; i++)
	{
		if (check[input[i]] == false && used[i] == false)
		{
			used[i] = true;
			arr[cnt] = input[i];
			check[input[i]] = true;
			solve(i, cnt + 1);
			used[i] = false;
		}
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++) scanf("%d", input + i);
	std::sort(input, input + N);
	solve(0, 0);
	return 0;
}