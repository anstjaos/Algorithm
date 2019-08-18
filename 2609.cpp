#include <iostream>
#include <algorithm>
using namespace std;

int num;
int num1;

int main()
{
	cin >> num >> num1;
	int minNum = min(num, num1);
	while (1)
	{
		if (num % minNum == 0 && num1 % minNum == 0) break;
		else minNum--;
	}
	cout << minNum << endl;
	minNum = min(num, num1);
	while (1)
	{
		if (minNum % num == 0 && minNum % num1 == 0) break;
		else minNum++;
	}
	cout << minNum << endl;
}