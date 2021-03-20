#include <iostream>
using namespace std;

int result = 1;
int main()
{
	int num;
	cin >> num;

	for (int i = num; i > 0; i--)
	{
		result = result *i;
	}
	cout << result << endl;
}