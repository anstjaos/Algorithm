#include <iostream>
using namespace std;

int testCase;
int num;
int arr[12] = { 0, };
int main()
{
	cin >> testCase;
	arr[0] = 1;
	for (int i = 1; i <= 11; i++)
	{
		if (i - 1 >= 0) arr[i] = arr[i] + arr[i - 1];
		if (i - 2 >= 0) arr[i] = arr[i] + arr[i - 2];
		if (i - 3 >= 0) arr[i] = arr[i] + arr[i - 3];
	}

	for (int i = 0; i < testCase; i++)
	{
		cin >> num;
		cout << arr[num] << endl;
	}
}