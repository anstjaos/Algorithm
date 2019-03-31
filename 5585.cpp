#include <iostream>
using namespace std;

int money, result = 0;

int main()
{
	cin >> money;
	money = 1000 - money;
	result = result + (money / 500);
	money = money % 500;
	result = result + (money / 100);
	money = money % 100;
	result = result + (money / 50);
	money = money % 50;
	result = result + (money / 10);
	money = money % 10;
	result = result + (money / 5);
	money = money % 5;
	result = result + money;
	
	cout << result << '\n';
	return 0;
}