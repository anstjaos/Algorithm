#include <iostream>
using namespace std;

int num;
int num1;
int maxnum = 0;

int main()
{
	int result = 0;
	for (int i = 0; i < 10; i++)
	{
		cin >> num >> num1;
		result = result - num + num1;
		if (result > maxnum) maxnum = result;
	}
	cout << maxnum << endl;
}