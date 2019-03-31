#include <iostream>
using namespace std;

int N, M, K,a, b, height;
long long arr[4000002], c;

long long sum(int left, int right, int cur, int curL, int curR)
{
	if (right < curL || left > curR) return 0;
	if (left <= curL && curR <= right) return arr[cur];

	int mid = (curL + curR) / 2;
	return sum(left, right, cur * 2, curL, mid) + sum(left, right, cur * 2 + 1, mid + 1, curR);
}
//
//long long findSum(int left, int right)
//{
//	if (right - left + 1 == N) return arr[1];
//
//	return sum(left, right, 2, 1, (1<<height-1)) + sum(left, right, 3, (1<<height-1)+ 1, N);
//}

int main()
{
	scanf("%d %d %d", &N, &M, &K);
	while ((1 << height) < N) height++;

	for (register int i = 0; i < N; i++)
	{
		scanf("%lld", arr + (1 << height) + i);
	}

	for (register int i = height-1; i >= 0; i--)
	{
		for (register int j = (1 << i); j < (1 << (i + 1)); j++)
		{
			arr[j] = arr[j * 2] + arr[j * 2 + 1];
		}
		
	}

	for (register int i = 0; i < M+K; i++)
	{
		scanf("%d %d %lld", &a, &b, &c);
		if (a == 1) 
		{
			arr[(1 << height) + b-1] = c;
			int temp = ((1 << height) + b-1) / 2;
			while (temp > 0)
			{
				arr[temp] = arr[temp * 2] + arr[temp * 2+1];
				temp = temp / 2;
			}
		}
		else
		{
			int temp = 1 << height;
			printf("%lld\n", sum(b, c,1,1,temp));
		}
	}
	return 0;
}