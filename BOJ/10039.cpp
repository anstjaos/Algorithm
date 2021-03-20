#include <iostream>
using namespace std;

int main()
{
	int result = 0;
	int num;
	for (int i = 0; i < 5; i++)
	{
		cin >> num;
		if (num < 40) num = 40;
		result = result + num;
	}
	cout << result / 5 << endl;
	return 0;
}