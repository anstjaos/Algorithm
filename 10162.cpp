#include <iostream>
using namespace std;

int num;
int arr[3] = { 300, 60, 10 };
int check[3] = { 0, };

int main()
{
	cin >> num;
	
	for (int i = 0; i < 3; i++)
	{
		check[i] = num / arr[i];
		if (num / arr[i] != 0)
		{
			num = num % arr[i];
		}
	}

	if (num == 0)
	{
		for (int i = 0; i < 3; i++) cout << check[i] << " ";

		cout << '\n';
	}
	else cout << -1 << '\n';
	
	return 0;
}