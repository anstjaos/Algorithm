#include <iostream>
using namespace std;

int month[13] = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
int m, d, days;

int main()
{
	cin >> d >> m;

	for (int i = 1; i < m; i++) days += month[i];
	days += d;

	int check = days % 7;

	switch (check)
	{
	case 0:
		cout << "Wednesday\n";
		break;
	case 1:
		cout << "Thursday\n";
		break;
	case 2:
		cout << "Friday\n";
		break;
	case 3:
		cout << "Saturday\n";
		break;
	case 4:
		cout << "Sunday\n";
		break;
	case 5:
		cout << "Monday\n";
		break;
	case 6:
		cout << "Tuesday\n";
		break;
	}

	return 0;
}