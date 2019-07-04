#include <stdio.h>

int A, B;

int main()
{
	scanf("%d %d", &A, &B);
	if (A > B) printf(">\n");
	else if (A < B) printf("<\n");
	else printf("==\n");
	return 0;
}