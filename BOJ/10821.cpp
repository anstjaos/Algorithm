#include <iostream>
using namespace std;

char input[101];

int strLen()
{
	int index = 0;
	
	while (input[index] != '\0') index++;

	return index;
}

int main()
{
	cin >> input;

	int size = strLen();
	int result = 0;
	for (int i = 0; i < size; i++)
	{
		if (input[i] == ',') result++;
	}

	result++;

	cout << result << endl;
	return 0;
}