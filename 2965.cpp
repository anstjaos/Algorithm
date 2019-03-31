#include <iostream>
using namespace std;

int num, num1, num2;
int main()
{
	cin >> num >> num1 >> num2;

	if (num1 - num > num2 - num1)
	{
		cout << num1 - num - 1 << endl;
	}
	else cout << num2 - num1 - 1 << endl;
}