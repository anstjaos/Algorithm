#include <iostream>
using namespace std;

int main()
{
	int result = 1;
	for (int i = 3; i <= 1000; i++)
	{
		result *= i;
	}
	cout << result << endl;
}