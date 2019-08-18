#include <iostream>
using namespace std;

int main()
{
	int price;
	cin >> price;

	for (int i = 0; i < 9; i++)
	{
		int num;
		cin >> num;
		price = price - num;
	}
	cout << price << endl;
	return 0;
}