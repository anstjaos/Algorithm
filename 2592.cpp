#include <iostream>

using namespace std;

int arr[101] = { 0, };
int num;
int sum = 0;
int m = 0;
int mindex = 0;
int main()
{
	for (int i = 0; i < 10; i++)
	{
		cin >> num;
		sum = sum + num;
		arr[num / 10]++;
		if (arr[num / 10] >= m)
		{
			m = arr[num / 10];
			mindex = num;
		}
	}

	cout << sum / 10 << endl;
	cout << mindex << endl;
}