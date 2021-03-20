#include <iostream>
using namespace std;

int L, P, V, result, divisor, divElse, cnt;

int main()
{
	while (1)
	{
		cnt++;
		result = 0;
		scanf("%d %d %d", &L, &P, &V);
		if (L == 0 && P == 0 && V == 0) break;

		divisor = V / P;
		divElse = V % P;

		result = divisor * L;
		
		if (divElse / L >= 1) {
			result += L;
		}
		else result += divElse;

		printf("Case %d: %d\n", cnt, result);
	}
	return 0;
}