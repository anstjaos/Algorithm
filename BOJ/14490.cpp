#include <iostream>
using namespace std;

int A, B;
char x;

int main()
{
	scanf("%d %c %d", &A, &x, &B);

	int num, num1;
	num = A;
	num1 = B;
	if (B > A)
	{
		num = B;
		num1 = A;
	}
	while (1)
	{
		if (num % num1 == 0) break;
		int temp = num1;
		num1 = num % num1;
		num = temp;
	}

	printf("%d:%d\n", A/num1, B/num1);
	return 0;
}