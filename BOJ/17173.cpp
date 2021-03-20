#include <stdio.h>

bool check[1001];
int N, M, arr[1001], sum;

int main()
{
	scanf("%d %d", &N, &M);

	for (register int i = 0; i < M; i++) scanf("%d", arr + i);

	for (register int i = 0; i < M; i++)
	{
		for (register int j = 1; j *arr[i] <= N; j++) {
			check[j*arr[i]] = true;
		}
	}

	for (register int i = 0; i <= N; i++) {
		if (check[i]) sum += i;
	}

	printf("%d\n", sum);
	return 0;
}