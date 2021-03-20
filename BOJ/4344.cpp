#include <iostream>
using namespace std;

int testCase, student[1001], stuCnt;

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> stuCnt;
		int sum = 0;
		for(int j =0 ; j < stuCnt ;j++)
		{
			cin >> student[j];
			sum = sum + student[j];
		}
		int result = 0;

		for (int j = 0; j < stuCnt; j++)
		{
			if (student[j] > sum / stuCnt) result++;
		}
		printf("%.3f", result * 100.0 / stuCnt);
		cout << "%" << endl;
	}
	return 0;
}