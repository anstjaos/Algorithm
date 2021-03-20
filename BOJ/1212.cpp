#include <iostream>
using namespace std;

char input[444444];
int arr[10000001];
int arrIndex = 0;

int strlen1(char *arr)
{
	int index = 0;
	while (arr[index] != '\0') index++;
	return index;

}

void passingNum(int num, bool flag)
{
	for (int i = 0; i < 3; i++)
	{
		if (flag == true && num == 0) break;
		arr[arrIndex++] = num % 2;
		num = num / 2;
	}
}

int main()
{
	cin >> input;
	int len = strlen1(input);
	bool flag = false;
	for(int i =len-1; i >=0; i--)
	{
		if (i == 0) flag = true;
		passingNum(input[i]-'0', flag);
	}

	if (arrIndex == 0)
	{
		cout << "0" << endl;
		return 0;
	}

	for (int i = arrIndex - 1; i >= 0; i--)
	{
		cout << arr[i];
	}
	cout << endl;
	return 0;
}
