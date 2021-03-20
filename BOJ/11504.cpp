#include <iostream>
using namespace std;

int N, M, temp, arr[101],tc, res;
long long X, Y, result[101];

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		X = Y = 0;
		res = 0;
		scanf("%d %d", &N, &M);
		for (int i = 0; i < M; i++)
		{
			scanf("%d", &temp);
			X = X * 10 + temp;
		}

		for (int i = 0; i < M; i++)
		{
			scanf("%d", &temp);
			Y = Y * 10 + temp;
		}

		for (int i = 0; i < N; i++)
		{
			scanf("%d", &arr[i]);
		}

		for (int i = 0; i < N; i++)
		{
			long long t = 0;
			for (int j = 0; j < M; j++)
			{
				t = t * 10 + arr[(i + j) % N];
			}
			result[i] = t;
		}

		for (int i = 0; i < N; i++)
		{
			if (result[i] >= X && result[i] <= Y) res++;
		}

		printf("%d\n", res);
	}
	return 0;
}