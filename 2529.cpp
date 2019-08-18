#include <iostream>
#include <string>
using namespace std;

char input[10];
int n;
bool check[10];
long long maxNum = -1, minNum = 9999999999;

long long min(long long a, long long b) { return (a > b ? b : a); }
long long max(long long a, long long b) { return (a > b ? a : b); }

void solve(long long result, int index)
{
	if (index == n)
	{
		minNum = min(minNum, result);
		maxNum = max(maxNum, result);

		return;
	}

	for (int i = 0; i < 10; i++)
	{
		if (check[i] == false)
		{
			if (input[index] == '>')
			{
				if (result % 10 > i)
				{
					check[i] = true;
					solve(result * 10 + i, index + 1);
					check[i] = false;
				}
			}
			else
			{
				if (result % 10 < i)
				{
					check[i] = true;
					solve(result * 10 + i, index + 1);
					check[i] = false;
				}
			}
		}
	}
}

int main()
{
	cin >> n;
	for (int i = 0; i < n; i++) cin >> input[i];

	for (int i = 0; i <= 9; i++)
	{
		check[i] = true;
		solve(i, 0);
		check[i] = false;
	}

	string max="", min="";
	for (int i = 0; i <= n; i++)
	{
		max += '0';
		min += '0';
	}

	for (int i = n; i >= 0; i--)
	{
		max[i] = maxNum % 10 + '0';
		maxNum = maxNum / 10;
		min[i] = minNum % 10 + '0';
		minNum = minNum / 10;
	}
	cout << max << "\n";
	cout << min << "\n";

	return 0;
}