#include <iostream>
using namespace std;

int fibo[21];

int getNthFibo(int num)
{
	if (num <= 1) return num;
	else if (fibo[num] != 0) return fibo[num];

	fibo[num] = getNthFibo(num - 1) + getNthFibo(num - 2);
	return fibo[num];
	
}

int main()
{
	fibo[0] = 0;
	fibo[1] = 1;

	int n;
	cin >> n;
	cout << getNthFibo(n) << '\n';
	return 0;
}