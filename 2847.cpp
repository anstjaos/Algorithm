#include <iostream>
using namespace std;

int arr[101], cnt, result;

int main()
{
	cin >> cnt;
	for (int i = 0; i < cnt; i++) cin >> arr[i];

	for (int i = cnt - 2; i >= 0; i--)
	{
		if (arr[i] >= arr[i + 1])
		{
			result += arr[i] - arr[i + 1] + 1;
			arr[i] = arr[i + 1] - 1;
		}
	}

	cout << result << endl;
	return 0;
}