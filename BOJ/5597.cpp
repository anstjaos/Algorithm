#include <iostream>
using namespace std;

bool arr[31];
int num;

int main()
{
	for (int i = 0; i < 28; i++)
	{
		cin >> num;
		arr[num] = true;
	}

	for (int i = 1; i <= 30; i++)
	{
		if (arr[i] == false)
		{
			cout << i << endl;
		}
	}
}