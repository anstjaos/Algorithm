#include <iostream>
using namespace std;

int hour, minute, second;
int remain;

int main()
{
	cin >> hour >> minute >> second >> remain;

	second = second + (remain % 60);
	minute = minute + (remain / 60);

	while (second >= 60)
	{
		second -= 60;
		minute++;
	}
	while (minute >= 60)
	{
		minute -= 60;
		hour++;
	}

	while (hour >= 24)
	{
		hour -= 24;
	}

	printf("%d %d %d\n", hour, minute, second);
}