#include <iostream>
using namespace std;

int main()
{
	int test;
	cin >> test;
	for (int i = 0; i < test; i++)
	{
		int num, num1;
		cin >> num >> num1;
		cout << "Case #" << i + 1 << ": " << num << " + " << num1 << " = " << num + num1 << endl;
	}
}