#include <iostream>
using namespace std;

int testCase;
int num1;
int num2;
int biggerNum;
int smallNum;
int result;

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> num1 >> num2;
		if (num1 > num2)
		{
			biggerNum = num1;
			smallNum = num2;
		}
		else
		{
			biggerNum = num2;
			smallNum = num1;
		}

		for (int i = 1; i <= biggerNum; i++)
		{
			result = biggerNum * i;
			if (result % smallNum == 0) break;
		}
		cout << result << endl;
	}
	return 0;
}