#include <iostream>
using namespace std;

int main()
{
	int num, num1;
	while (1)
	{
		cin >> num >> num1;
		if (num == 0 && num1 == 0) break;

		cout << num + num1 << endl;
	}
}