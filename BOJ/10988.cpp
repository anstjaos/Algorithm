#include <cstdio>

char input[101];
int len;

bool check()
{
	int left = 0, right = len - 1;

	while (left <= right)
	{
		if (input[left] != input[right]) return false;
		left++;
		right--;
	}
	return true;
}

int main()
{
	scanf("%s", input);
	while (input[len] != '\0') len++;

	check() ? printf("1\n") : printf("0\n");
	return 0;
}