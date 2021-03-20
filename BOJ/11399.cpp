#include <iostream>
#include <algorithm>
using namespace std;

int testCase;
int arr[1001];
int result = 0;
int num = 0;
int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++) cin >> arr[i];
	sort(arr, arr+testCase);
	for (int i = 0; i < testCase; i++)
	{
		for (int j = 0; j <= i; j++) num = num + arr[j];
		result = result + num;
		num = 0;
	}
	cout << result << endl;
}