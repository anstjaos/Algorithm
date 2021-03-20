#include <iostream>
using namespace std;
#define MAX_SIZE 10000001
long long arr[MAX_SIZE], P, Q;
long long N;

long long solve(long long n)
{
	long long a, b;
	if (n / P > MAX_SIZE) a = solve(n / P);
	else a = arr[n / P];

	if (n / Q > MAX_SIZE) b = solve(n / Q);
	else b = arr[n / Q];

	return a + b;
}

int main()
{
	scanf("%lld %lld %lld", &N, &P, &Q);
	arr[0] = 1;
	for (register int i = 1; i < MAX_SIZE && i <= N; i++)
	{
		arr[i] = arr[i / P] + arr[i / Q];
	}

	printf("%lld\n", solve(N));
	return 0;
}