#include <iostream>
#include <algorithm>
using namespace std;

int arr[3], diff[2], result;

int main()
{
	for (int i = 0; i < 3; i++) cin >> arr[i];
	sort(arr, arr + 3);

	for (int i = 0; i < 2; i++)
	{
		diff[i] = arr[i + 1] - arr[i];
	}

	if (diff[0] > diff[1])
	{
		result = arr[1] - diff[1];
	}
	else if (diff[0] < diff[1])
	{
		result = arr[1] + diff[0];
	}
	else result = arr[2] + diff[0];

	cout << result << endl;
	return 0;
}