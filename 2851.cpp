#include <iostream>
using namespace std;

int temp, arr[10], differ = 2123456789, maxNum;

int abs(int a)
{
	if (a < 0)return a * -1;
	return a;
}

int main()
{
	cin >> arr[0];
	differ = abs(100 - arr[0]);
	maxNum = arr[0];

	for (int i = 1; i < 10; i++)
	{
		cin >> temp;
		arr[i] = arr[i - 1] + temp;

		int check = abs(100 - arr[i]);
		if (check <= differ)
		{
			differ = check;
			maxNum = arr[i];
		}

	}

	cout << maxNum << endl;
	return 0;
}