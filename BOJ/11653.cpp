#include <iostream>
using namespace std;

int num;
int divisor = 2;

int main()
{
	cin >> num;
	while (num > 1)
	{
		if (num % divisor == 0)
		{
			num = num / divisor;
			cout << divisor << endl;
		}
		else
		{
			divisor++;
		}
	}
	return 0;
}