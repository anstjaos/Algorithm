#include <stdio.h>

char input[1005];
int l, r;

int main()
{
	scanf("%s", input);
	int idx = 0;

	while (input[idx] != '(')
	{
		if (input[idx] == '@') l++;
		idx++;
	}

	while (input[idx] != '\0')
	{
		if (input[idx] == '@') r++;
		idx++;
	}

	printf("%d %d\n", l, r);
	return 0;
}