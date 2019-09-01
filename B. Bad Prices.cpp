#include <stdio.h>

int tc, n, arr[150001];

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d", &n);
		for (register int i = 0; i < n; i++) scanf("%d", arr + i);
		int minVal = arr[n - 1];
		int cnt = 0;

		for (register int i = n - 1; i >= 0; i--) {
			if (arr[i] > minVal) cnt++;
			else minVal = arr[i];
		}

		printf("%d\n", cnt);
	}

	return 0;
}