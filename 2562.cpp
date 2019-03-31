#include <iostream>
#include <algorithm>
using namespace std;

int num;
int cnt;
int maxNum = 0;

int main()
{
	for (int i = 0; i < 9; i++)
	{
		cin >> num;
		if (num > maxNum)
		{
			maxNum = num;
			cnt = i + 1;
		}
	}
	cout << maxNum << endl;
	cout << cnt << endl;
}