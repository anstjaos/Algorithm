#include <iostream>
using namespace std;

long long arr[91];
int num;

long long fibo(int num)
{
	if (num == 0) return 0;
	else if (num == 1 || num == 2) return 1;
	
	if (arr[num] != 0) return arr[num];

	long long result = fibo(num - 1) + fibo(num - 2);
	arr[num] = result;
	return result;
}

int main()
{
	cin >> num;
	cout << fibo(num) << endl;
	return 0;
}