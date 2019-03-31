#include <iostream>

int N, S, arr[100001], l, r, sum, result;

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d %d", &N, &S);
	for (register int i = 0; i < N; i++) scanf("%d", arr + i);
	
	result = 2123456789;
	while (1)
	{
		if (sum >= S) {
			result = min(result, r - l);
			sum -= arr[l++];
		}
		else if (r == N) break;
		else if(sum < S)
		{
			sum += arr[r];
			r++;
		}
	}

	printf("%d\n", result > N ? 0 : result);
	return 0;
}