#include <iostream>
using namespace std;

int arr[40000][5];

void init()
{
	for (int i = 1; i *i < 40000; i++)
	{
		arr[i*i][1]++;
	}

	for (int i = 2; i <= 4; i++) arr[i][i]++;

	for (int i = 5; i < 40000; i++)
	{
		for (int j = 1; j <i; j++)
		{
			for (int k = 1; k < 4; k++)
			{
				arr[i][k] += arr[i - j][4 - k];
			}
		}
	}
}

int main()
{
	init();
	int input, result;
	while (1)
	{
		result = 0;
		cin >> input;
		if (input == 0) break;

		for (int i = 1; i <= 4; i++)
		{
			result = result + arr[input][i];
		}

		cout << result << endl;
	}
	return 0;
}