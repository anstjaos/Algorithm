#include <iostream>
using namespace std;

int year;

int main()
{
	cin >> year;

	int gan = year % 10;
	int ji = year % 12;

	gan = (gan + 6) % 10;
	ji = (ji + 8) % 12;

	cout << (char)(ji + 'A') << gan << endl;
	return 0;
}