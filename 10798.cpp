#include <iostream>
using namespace std;

char input[5][20];
int maxLen = -1;

int strlen1(char *arr)
{
	int index = 0;
	while (arr[index] != '\0') index++;

	return index;
}

int main()
{
	for (int i = 0; i < 5; i++)
	{
		cin.getline(input[i], 20);
		int len = strlen1(input[i]);
		if (len > maxLen) maxLen = len;
	}
	
	for (int i = 0; i < maxLen; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			if (input[j][i] != '\0')
			{
				cout << input[j][i];
			}
		}
	}

	cout << endl;
	return 0;
}