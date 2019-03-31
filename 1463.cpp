#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000001];

int findNum(int n)
{
	if (n == 1) return 0;
	if (arr[n] != -1) return arr[n];

	int result = findNum(n - 1) + 1;

	if (n % 3 == 0) result = min(result, findNum(n /3) + 1);
	if (n % 2 == 0) result = min(result, findNum(n / 2) + 1);
	arr[n] = result;
	return result;
}

int main()
{
	memset(arr, -1,1000001*sizeof(int));
	int num;
	cin >> num;
	cout << findNum(num) << endl;
	return 0;
}