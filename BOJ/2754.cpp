#include <iostream>
#include <string>
using namespace std;

int main()
{
	string score;
	double result;

	cin >> score;

	if (score == "A+") result = 4.3;
	else if (score == "A0") result = 4.0;
	else if (score == "A-") result = 3.7;
	else if (score == "B+") result = 3.3;
	else if (score == "B0") result = 3.0;
	else if (score == "B-") result = 2.7;
	else if (score == "C+") result = 2.3;
	else if (score == "C0") result = 2.0;
	else if (score == "C-") result = 1.7;
	else if (score == "D+") result = 1.3;
	else if (score == "D0") result = 1.0;
	else if (score == "D-") result = 0.7;
	else if (score == "F") result = 0.0;

	printf("%.1f\n", result);
	return 0;
}