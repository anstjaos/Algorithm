#include <iostream>

int L, fail[1000001];
char input[1000001];

int main()
{
	scanf("%d %s", &L, input);


	for (int i = 1, j = 0; i < L; i++) {
		while (j > 0 && input[i] != input[j]) j = fail[j - 1];
		if (input[i] == input[j]) fail[i] = ++j;
	}

	if (fail[L - 1] == 0) printf("%d\n", L);
	else printf("%d\n", L - fail[L - 1]);

	return 0;
}