#include <cstdio>
#include <math.h>
#define MAX_SIZE 10000001

long long N, M;
int div, arr[MAX_SIZE];
bool primeNum[MAX_SIZE];

void init()
{
	for (register int i = 2; i < MAX_SIZE; i++) primeNum[i] = true;
	
	for (register int i = 2; i*i < MAX_SIZE; i++)
	{
		if (primeNum[i]) {
			for (register int j = i * i; j < MAX_SIZE; j += i) primeNum[j] = false;
		}
	}
}

int main()
{
	scanf("%lld %lld", &N, &M);
	long long mul = (N*N) + (M*M);
	long long res = 1, temp = 1;
	init();
	for (register int i = 2; i < MAX_SIZE; i++)
	{
		if (i >= mul) break;
		if (primeNum[i] == false) continue;
		
		while (mul % i == 0)
		{
			mul = mul / i;
			arr[i]++;
		}
		if (arr[i] != 0 && ((arr[i] >> 1) << 1) == arr[i]) {
			res *= (i * arr[i]/2);
		}
		else if (arr[i] != 0) {
			res *= (i * (arr[i] - 1)/2);
		}
	}
	res *= ceil(sqrt(mul));
	printf("%lld\n", res);
	return 0;
}