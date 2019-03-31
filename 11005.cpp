#include <iostream>
using namespace std;

int num;
int n;
int arr[40];
int arrCnt = 0;

int main()
{
	cin >> num >> n;

	while (num > 0)
	{
		arr[arrCnt++] = num %n;
		num = num / n;
	}
	for (int i = arrCnt - 1; i >= 0; i--)
	{
		if (arr[i] >= 10)
		{
			char value = 'A' + arr[i] - 10;
			cout << value;
		}
		else cout << arr[i];
	}
	cout << endl;
	return 0;
}