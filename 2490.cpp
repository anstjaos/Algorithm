#include <iostream>
using namespace std;

int arr[2], num;

int main()
{
	for (int i = 0; i < 3; i++)
	{
		arr[0] = arr[1] = 0;
		for (int j = 0; j < 4; j++)
		{
			cin >> num;
			arr[num]++;
		}

		if (arr[0] == 0) cout << "E" << '\n';
		else if (arr[0] == 1) cout << "A" << '\n';
		else if (arr[0] == 2) cout << "B" << '\n';
		else if (arr[0] == 3) cout << "C" << '\n';
		else if (arr[0] == 4) cout << "D" << '\n';
	}
	return 0;
}