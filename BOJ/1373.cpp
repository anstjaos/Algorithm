#include <iostream>
using namespace std;

char input[1000001];
int arr[1000001];
int arrIndex = 0;
int cnt = 0;

int strlen1(char *arr)
{
	int index = 0;
	while (arr[index] != '\0') index++;

	return index;
}

int findNum(int count)
{
	int result = 1;
	for (int i = 0; i < count; i++)
	{
		result = result * 2;
	}
	return result;
}

int main()
{
	cin >> input;
	int len = strlen1(input);
	int value = 0;
	for (int i = len - 1; i >= 0; i--)
	{
		if (cnt == 3)
		{
			arr[arrIndex++] = value;
			cnt = 0;
			value = 0;
		}

		if (input[i] == '1')
		{
			value = value + findNum(cnt);
		}
		cnt++;
	}
	arr[arrIndex++] = value;
	for (int i = arrIndex - 1; i >= 0; i--) cout << arr[i];

	cout << endl;
	return 0;
}