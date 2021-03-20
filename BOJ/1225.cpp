#include <iostream>
using namespace std;

char num[10001], num1[10001];
long long sum, sum1;

long long getSum(char num[10001])
{
	long long result = 0;
	int index = 0;
	while (num[index] != '\0')
	{
		result += num[index] - '0';
		index++;
	}

	return result;
}

int main()
{
	cin >> num >> num1;
	sum = getSum(num);
	sum1 = getSum(num1);
	long long result = sum * sum1;
	cout << sum * sum1 << endl;
	return 0;
}