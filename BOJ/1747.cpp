#include <iostream>
using namespace std;

bool prime[10000001];
int num;

void init()
{
	for (int i = 2; i < 10000001; i++) prime[i] = true;

	for (int i = 2; i*i < 10000001; i++)
	{
		if (prime[i] == true)
		{
			for (int j = i * i; j < 10000001; j+=i)
			{
				prime[j] = false;
			}
		}
	}
}

int length(int num)
{
	int cnt = 0;
	while (num != 0)
	{
		num = num / 10;
		cnt++;
	}
	return cnt;
}

int intPassing(int num, int index)
{
	int result = num;
	for (int i = 1; i < index; i++)
	{
		result = result / 10;
	}
	result = result % 10;
	return result;
}

bool isPelindrom(int n)
{
	int len = length(n);

	for (int i = 1; i <= len /2; i++)
	{
		if (intPassing(n, i) != intPassing(n, len - i+1)) return false;
	}
	return true;
}

int main()
{
	init();
	cin >> num;

	for (int i = num; i < 10000001; i++)
	{
		if (prime[i] == true)
		{
			if (isPelindrom(i) == true)
			{
				cout << i << endl;
				break;
			}
		}
	}
}