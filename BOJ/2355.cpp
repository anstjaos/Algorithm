#include <iostream>
using namespace std;

long long a, b;
long long result;

int main()
{
	cin >> a >> b;

	if (a < b)
	{
		if (a >= 0 && b >= 0)
		{
			result = (b*(b + 1)) / 2 - (a*(a - 1)) / 2;
		}
		else if (a < 0 && b < 0)
		{
			a *= -1;
			b *= -1;

			result = (a*(a + 1)) / 2 - (b*(b - 1)) / 2;
			result *= -1;
		}
		else if (a < 0 && b >= 0)
		{
			a *= -1;
			result = (b*(b + 1)) / 2 - (a*(a + 1)) / 2;
		}
	}
	else
	{
		if (a >= 0 && b >= 0)
		{
			result = (a*(a + 1)) / 2 - (b*(b - 1)) / 2;
		}
		else if (a < 0 && b < 0)
		{
			a *= -1;
			b *= -1;

			result = (b*(b + 1)) / 2 - (a*(a - 1)) / 2;
			result *= -1;
		}
		else if (b < 0 && a >= 0)
		{
			b *= -1;
			result = (a*(a + 1)) / 2 - (b*(b + 1)) / 2;
		}
	}
	cout << result << endl;
}