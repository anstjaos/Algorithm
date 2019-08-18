#include <iostream>
#include <string>
using namespace std;

string input;
int n;
int sum = 0;

int power(int num)
{
	int result = 1;
	for (int i = 0; i < num; i++)
	{
		result = result * n;
	}
	return result;
}

int main()
{
	cin >> input >> n;
	int length = input.length();
	for (int i = 0; i < length; i++)
	{
		if (isdigit(input[i]))
		{
			sum = sum + (input[i]-'0') * power(length-i-1);
		}
		else
		{
			sum = sum + (input[i] - 55) * power(length - i - 1);
		}
	}
	cout << sum << endl;
	return 0;
}