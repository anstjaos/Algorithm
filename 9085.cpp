#include <iostream>
using namespace std;

int testCase;
int testNum;
int num;
int result ;

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		result = 0;
		cin >> testNum;
		for (int j = 0; j < testNum; j++)
		{
			cin >> num;
			result = result + num;
		}
		cout << result << endl;
	}
}