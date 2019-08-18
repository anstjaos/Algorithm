#include <iostream>
using namespace std;

int num;

int pow(int base, int exponent)
{
	int result = 1;
	for (int i = 0; i < exponent; i++) result *= base;

	return result;
}

int main()
{
	cin >> num;

	int temp = pow(2, num);
	
	cout << (temp + 1) * (temp + 1) << "\n";
	return 0;
}