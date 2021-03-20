#include <iostream>
using namespace std;

int patientCnt=0;
int doctorCnt = 0;
char input;

int main()
{
	while (1)
	{
		cin >> input;
		if (input == 'h') break;
		patientCnt++;
	}

	while (1)
	{
		cin >> input;
		if (input == 'h') break;
		doctorCnt++;
	}

	if (doctorCnt > patientCnt) cout << "no" << endl;
	else cout << "go" << endl;
	return 0;
}