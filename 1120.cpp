#include <cstdio>

char A[51], B[51];
int Alen, Blen;

int min(int a, int b) { return (a < b ? a : b); }

int strlen(char* arr)
{
	int len = 0;
	while (arr[len] != '\0') len++;
	return len;
}

int findMin()
{
	int res = 2123456789;
	for (register int i = 0; i <= Blen - Alen; i++)
	{
		int diff = 0;
		for (register int j = 0; j < Alen; j++)
		{
			if (A[j] != B[i + j]) diff++;
		}
		res = min(res, diff);
	}
	return res;
}

int main()
{
	scanf("%s %s", A, B);
	Alen = strlen(A);
	Blen = strlen(B);

	int res = 0;
	res = findMin();
	printf("%d\n", res);
	return 0;
}