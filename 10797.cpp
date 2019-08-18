#include <iostream>
using namespace std;

int main()
{
	int cnt = 0;
	int num;
	cin >> num;

	for (int i = 0; i < 5; i++)
	{
		int num1;
		cin >> num1;
		if (num1 == num) cnt++;
	}
	cout << cnt << endl;
	return 0;
}