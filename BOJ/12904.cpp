#include <stdio.h>

char S[1000], T[1001];
int result;

bool strcmp(char* s, char* s1)
{
	int idx = 0;
	while ((s[idx] == s1[idx]) && s[idx] != '\0' && s1[idx]!='\0') idx++;

	if (s[idx] == '\0' && s1[idx] == '\0') return true;

	return false;
}

void reverse(char *s, int size)
{
	int l = 0, r = size - 1;

	while (l < r) {
		char temp = s[l];
		s[l] = s[r];
		s[r] = temp;

		l++;
		r--;
	}
}

int main()
{
	scanf("%s %s", S, T);

	int sSize = 0, tSize = 0;

	while (S[sSize] != '\0') sSize++;
	while (T[tSize] != '\0') tSize++;

	while (1)
	{
		if (sSize == tSize) {
			if (strcmp(S, T)) result = 1;
			break;
		}

		char temp = T[tSize - 1];
		T[--tSize] = '\0';

		if (temp == 'B') reverse(T, tSize);
	}
	printf("%d\n", result);
	return 0;
}