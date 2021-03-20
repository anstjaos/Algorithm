#include <iostream>
#include <algorithm>
using namespace std;

int arr[4];

int main()
{
	for (int i = 0; i < 4; i++) cin >> arr[i];

	sort(arr, arr + 4);

	int result = 0;
	if(arr[1] != arr[0] ) result = arr[2] * (arr[1] - arr[0]);
	else result = arr[2] * arr[1];

	cout << result << "\n";
	return 0;
}