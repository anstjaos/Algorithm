#include <iostream>
using namespace std;

int power(int num)
{
	int num1 = 1;
	for (int i = 0; i < num; i++)
	{
		num1 = num1 * 10;
	}
	return num1;
}
int main()
{
	int num, num1;
	cin >> num >> num1;

	for (int i = 0; i < 3; i++)
	{
		cout << num * (num1 / power(i) % 10) << endl;
	}
	cout << num * num1 << endl;
	return 0;
}