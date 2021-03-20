#include <iostream>
using namespace std;

int N, K, cnt;
bool prime[10001];

int main()
{
	cin >> N >> K;

	for (int i = 2; i <= N; i++) prime[i] = true;

	for (int i = 2; i <= N; i++)
	{
		if (prime[i] == true)
		{
			prime[i] = false;
			cnt++;

			if (cnt == K)
			{
				cout << i << '\n';
				return 0;
			}
			for (int j = 2; i*j <= N; j++)
			{
				if (prime[i*j] == true)
				{
					prime[i*j] = false;
					cnt++;
					if (cnt == K)
					{
						cout << i*j << '\n';
						return 0;
					}
				}
			}
		}
	}
	return 0;
}