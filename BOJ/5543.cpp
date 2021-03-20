#include <iostream>
#include <algorithm>
using namespace std;

int arr[5];

int main()
{
	for (int i = 0; i < 5; i++) cin >> arr[i];

	int result = min(min(arr[0], arr[1]), arr[2]) + min(arr[3], arr[4]);
	cout << result - 50 << endl;
	return 0;
}