#include <iostream>
using namespace std;

int main()
{
	int testCase;
	cin >> testCase;
	int num;
	int result = 0;
	for (int i = 0; i < testCase; i++)
	{
		cin >> num;
		result = result + num - 1;
	}
	cout << result + 1 << endl;
}