#include <iostream>
using namespace std;

char num1[5], num2[5];

int getTens(int num, int count)
{
	int result = num;

	for (int i = 0; i < count; i++) result = result * 10;

	return result;
}
	
int getReverse(char arr[5])
{
	int result = 0;
	for (int i = 0; i < 5; i++)
	{
		if (arr[i] == '\0') break;

		result += getTens(arr[i] - '0', i);
	}

	return result;
}

int main()
{
	cin >> num1 >> num2;

	int temp1 = getReverse(num1);
	int temp2 = getReverse(num2);

	int result = temp1 + temp2;

	int index = 0;
	while (result != 0)
	{
		num1[index] = result % 10;
		result = result / 10;
		index++;
	}

	result = 0;
	for (int i = 0; i < index; i++)
	{
		result += getTens(num1[i], index-i-1);
	}

	cout << result << endl;
	return 0;
}