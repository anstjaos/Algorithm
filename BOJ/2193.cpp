#include <iostream>
using namespace std;

long long result[90] = { 0, };

long long fibonacci(int num)
{
	if (num == 1) return 1;
	else if (num == 2) return 1;
	
	if (result[num] != 0) return result[num];

	result[num] = fibonacci(num - 1) + fibonacci(num - 2);
	return result[num];
}

int main()
{
		int num;
		cin >> num;
		
		cout << fibonacci(num) << endl;
	
	return 0;
}