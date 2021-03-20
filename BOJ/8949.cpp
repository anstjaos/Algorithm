#include <iostream>
using namespace std;

int a[1000001] = { 0, };
int b[1000001] = { 0, };
int aIndex = 0;
int bIndex = 0;
int result[1000001] = { 0, };
int num;

int main()
{
	cin >> num;
	while (num != 0)
	{
		a[aIndex] = num % 10;
		num = num / 10;
		aIndex++;
	}

	cin >> num;
	while (num != 0)
	{
		b[bIndex] = num % 10;
		num = num / 10;
		bIndex++;
	}
	
	for (int i = 0; i < aIndex; i++) result[i] = a[i];
	for (int i = 0; i < bIndex; i++) result[i] = result[i] + b[i];

	if (aIndex > bIndex)
	{
		for (int i = aIndex - 1; i >= 0; i--) cout << result[i];
	}
	else
	{
		for (int i = bIndex - 1; i >= 0; i--) cout << result[i];
	}
	cout << endl;
	return 0;
}