#include <iostream>
using namespace std;

bool prime[300001];
int input;

void init()
{
	for (int i = 2; i < 300001; i++) prime[i] = true;

	for (int i = 2; i < 300001; i++)
	{
		if (prime[i] == true)
		{
			for (int j = i * 2; j < 300001; j += i)
			{
				prime[j] = false;
			}
		}
	}
}

int solve(int num)
{
	int cnt = 0;
	for (int i = num+1; i <= 2 * num; i++)
	{
		if (prime[i] == true) cnt++;
	}

	return cnt;
}

int main()
{
	init();
	while (1)
	{
		cin >> input;
		if (input == 0) break;

		cout << solve(input) << '\n';
	}
	return 0;
}