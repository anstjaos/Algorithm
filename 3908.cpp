#include <iostream>
using namespace std;

bool primeNum[1121];
int testCase, n, k;
long long cnt[1121][15];

void findPrimeNum()
{
	for (int i = 2; i < 1121; i++) primeNum[i] = true;

	for (int i = 2; i *i <= 1121; i++)
	{
		if (primeNum[i] == true)
		{
			
			for (int j = i * i; j < 1121; j += i)
			{
				primeNum[j] = false;
			}
		}
	}
}

void init()
{
	cnt[0][0] = 1;
	for (int i = 2; i <= 1120; i++)
	{
		if (primeNum[i] == true)
		{
			for (int j = 1120; j >= i; j--)
			{
				for (int k = 1; k < 15; k++)
				{
					cnt[j][k] += cnt[j-i][k - 1];
				}
				
			}
		}
		
	}

}

int main()
{
	findPrimeNum();
	init();
	cin >> testCase;
	
	for (int i = 0; i < testCase; i++)
	{
		cin >> n >> k;
		cout << cnt[n][k] << '\n';
	}
	return 0;
}