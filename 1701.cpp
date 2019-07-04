#include <stdio.h>

char arr[5005];
int res, len;

int max(int a, int b) { return (a > b ? a : b); }

void substr(char* desti, int start)
{
	register int i = 0;
	for (; i+start < len; i++) {
		desti[i] = arr[start + i];
	}
	desti[i] = '\0';
}

int getMaxPi(char* c, int size)
{
	int pi[5005];
	for (register int i = 0; i < 5005; i++) pi[i] = 0;
	int j = 0, ret = 0;

	for (register int i = 1; i < size; i++) {
		while (j > 0 && c[i] != c[j]) j = pi[j - 1];

		if (c[i] == c[j]) {
			pi[i] = ++j;
			ret = max(ret, pi[i]);
		}
	}
	return ret;
}

int main()
{
	scanf("%s", arr);
	char temp[5005];
	while (arr[len] != '\0') len++;
	for (register int i = 0; i < len; i++) {
		substr(temp, i);
		res = max(res, getMaxPi(temp, len-i));
	}
	printf("%d\n", res);
	return 0;
}