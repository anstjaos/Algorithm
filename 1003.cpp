#include <iostream>
using namespace std;

typedef struct {
	int zeroCnt, oneCnt;
}fibo;

fibo fiboArr[41];
int testCase;
int num;

fibo fibonacci(int n) {
	if (n == 0) {
		return fiboArr[0];
	}
	else if (n == 1) {
		return fiboArr[1];
	}

	if (fiboArr[n].zeroCnt != 0 && fiboArr[n].oneCnt != 0) return fiboArr[n];
	else {
		return { fibonacci(n - 1).zeroCnt + fibonacci(n - 2).zeroCnt, fibonacci(n - 1).oneCnt + fibonacci(n - 2).oneCnt };
	}
}
void init()
{
	fiboArr[0] = { 1,0 };
	fiboArr[1] = { 0,1 };

	for (int i = 2; i < 41; i++)
	{
		fiboArr[i] = fibonacci(i);
	}
}



int main()
{
	init();
	scanf(" %d", &testCase);
	for (int i = 0; i < testCase; i++)
	{
		scanf(" %d", &num);
		printf("%d %d\n", fiboArr[num].zeroCnt, fiboArr[num].oneCnt);
	}
	return 0;
}
