#include <stdio.h>

int q;
long long n, m;
bool check[11];
int visit[11], visitCnt;

int main()
{
	scanf("%d", &q);
	while (q--)
	{
		scanf("%lld %lld", &n, &m);
		for (register int i = 0; i < 11; i++) {
			check[i] = false;
			visit[i] = 0;
		}
		visitCnt = 0;

		long long sum = 0, temp = m;
		for (register int i = 1; i < 11; i++) {
			temp = m * i;
			if (check[temp % 10] == true) break;
			check[temp % 10] = true;
			visit[visitCnt++] = temp % 10;
			sum += temp % 10;
		}
		temp = n / m;
		long long res = temp / visitCnt * sum;
		temp = temp % visitCnt;
		for (register int i = 0; i < temp; i++) res += visit[i];

		printf("%lld\n", res);
	}

	return 0;
}