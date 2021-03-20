#include <iostream>
using namespace std;

int hour, minute;
int c;

int main()
{
	cin >> hour >> minute >> c;

	minute = minute + c;

	while (1)
	{
		if (minute < 60) break;

		minute = minute - 60;
		hour++;
		if (hour == 24) hour = 0;
	}
	cout << hour << " " << minute << endl;
}