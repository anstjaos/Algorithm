#include <stdio.h>
#include <cstring>

#define NMAX 3072
#define EMPTY ' '

char star[3][5] = { { EMPTY,EMPTY,'*',EMPTY,EMPTY },
					{ EMPTY,'*',EMPTY,'*',EMPTY },
					{ '*','*','*','*','*' } };

char arr[NMAX][NMAX * 2];
int cnt;

void solve(int n, int height, int first, int second)
{
	for (int i = 0; i < height; i++)
	{
		memcpy(arr[height + i] + (first), arr[i] + n - height, second);
		memcpy(arr[height + i] + (first)+second + 1, arr[i] + n - height, second);
		arr[height + i][n * 2 - 1] = '\0';
		puts(arr[height + i]);
		cnt++;
	}
	if (cnt < n)
		solve(n, height * 2, first - (height * 2), (second * 2) + 1);
}

void init(int n)
{
	for (int i = 0; i < 3; i++)
	{
		memcpy(arr[i] + (n - 3), star[i], 5);
		arr[i][n * 2 - 1] = '\0';
		puts(arr[i]);
	}
}

int main()
{
	int n;
	memset(arr, EMPTY, sizeof(arr));
	scanf("%d", &n);

	init(n);
	cnt = 3;
	if (n > 3)
		solve(n, 3, n - 6, 5);
}