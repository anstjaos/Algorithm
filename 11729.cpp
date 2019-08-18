#include <iostream>
using namespace std;

int N;

void hanoi(int num, int a, int b, int left)
{
	if (num == 1) {
		printf("%d %d\n", a, b);
		return;
	}

	hanoi(num - 1, a, left, b);
	printf("%d %d\n", a, b);
	hanoi(num - 1, left, b, a);
}

int main()
{
	scanf("%d", &N);
	printf("%d\n", (1 << N) - 1);
	hanoi(N, 1, 3, 2);
}