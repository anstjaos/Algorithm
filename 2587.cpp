#include <iostream>
#include <algorithm>
using namespace std;

int arr[5];

int main()
{
	int result = 0;
	for (int i = 0; i < 5; i++)
	{
		cin >> arr[i];
		result = result + arr[i];
	}
	sort(arr, arr + 5);
	cout << result /5<< endl;
	cout << arr[2] << endl;
	
}