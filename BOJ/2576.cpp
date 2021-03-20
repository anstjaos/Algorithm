#include <iostream>
using namespace std;

int arr[7], result, minOdd = 2123456789;

int main()
{
	for (int i = 0; i < 7; i++)
	{
		cin >> arr[i];
		if (arr[i] % 2 == 1)
		{
			result += arr[i];

			if (arr[i] < minOdd) minOdd = arr[i];
		}
	}

	if (result == 0) cout << "-1\n";
	else
	{
		cout << result << "\n" << minOdd << "\n";
	}

	return 0;
}