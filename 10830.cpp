#include <iostream>
using namespace std;
long long a[6][6], ans[6][6], c[6][6], n, b;
void cal(long long a[6][6], long long b[6][6])
{
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
		{
			c[i][j] = 0;
			for (int k = 1; k <= n; k++)
			{
				c[i][j] += a[i][k] * b[k][j];
			}
			c[i][j] %= 1000;
		}
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			a[i][j] = c[i][j];

}
int main() {
	cin >> n >> b;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			cin >> a[i][j];

		}
		ans[i][i] = 1;
	}

	while (b > 0)
	{
		if (b % 2 == 1)//지수가 홀수면
		{
			cal(ans, a);
		}
		cal(a, a);
		b /= 2;
	}
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
			cout << ans[i][j] << ' ';
		cout << '\n';
	}
}