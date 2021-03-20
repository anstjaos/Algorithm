#include <iostream>
using namespace std;

int nume1, deno1, nume2, deno2, nume3, deno3;
bool prime[30001];

int min(int a, int b) { return (a < b ? a : b); }
void init()
{
	for (int i = 2; i < 30001; i++) prime[i] = true;

	for (int i = 2; i * i < 30001; i++)
	{
		if (prime[i] == true)
		{
			for (int j = i*2; j < 30001; j += i) prime[j] = false;
		}
	}
}

int gcd(int a, int b)
{
	int c;
	while (b)
	{
		c = a % b;
		a = b;
		b = c;
	}
	return a;
}

int main()
{
	cin >> nume1 >> deno1 >> nume2 >> deno2;
	init();
	int tempDeno = gcd(deno1,deno2);
	deno3 = tempDeno * (deno1 / tempDeno) * (deno2 / tempDeno);

	nume1 = nume1 * (deno3 / deno1);
	nume2 = nume2 * (deno3 / deno2);

	nume3 = nume1 + nume2;
	tempDeno = gcd(nume3, deno3);
	nume3 = nume3 / tempDeno;
	deno3 = deno3 / tempDeno;
	cout << nume3 << " " << deno3 << endl;
	return 0;
}