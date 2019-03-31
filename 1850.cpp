#include <iostream>
using namespace std;

long long int A, B;

long long int gcd(long long int A, long long int B)
{
	if (A < B) {
		swap(A, B);
	}

	while (B != 0)
	{
		int temp = A % B;
		A = B;
		B = temp;
	}

	return A;
}

int main()
{
	scanf("%lld %lld", &A, &B);
	long long int temp = gcd(A, B);
	for (register long long int i = 0; i < temp; i++) {
		printf("1");
	}
	printf("\n");
	return 0;
}